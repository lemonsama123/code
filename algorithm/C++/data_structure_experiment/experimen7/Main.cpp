#include <bits/stdc++.h>

#define MAX_VERtEX_NUM 20
#define VRType int
#define VertexType int

bool visited[MAX_VERtEX_NUM];

typedef struct {
    VRType adj;
} ArcCell, AdjMatrix[MAX_VERtEX_NUM][MAX_VERtEX_NUM];

typedef struct {
    VertexType vexs[MAX_VERtEX_NUM];
    AdjMatrix arcs;
    int vexnum, arcnum;
} MGraph;

typedef struct CSNode {
    VertexType data;
    struct CSNode *lchild;
    struct CSNode *nextsibling;
} * CSTree, CSNode;

int LocateVex(MGraph G, VertexType v) {
    int i = 0;
    for (; i < G.vexnum; i++) {
        if (G.vexs[i] == v) {
            break;
        }
    }
    if (i > G.vexnum) {
        printf("no such vertex.\n");
        return -1;
    }
    return i;
}

void CreateDN(MGraph *G) {
    scanf("%d, %d ", &(G->vexnum), &(G->arcnum));
    getchar();
    for (int i = 0; i < G->vexnum; i++) {
        scanf("%d", &(G->vexs[i]));
    }
    for (int i = 0; i < G->vexnum; i++) {
        for (int j = 0; j < G->vexnum; j++) {
            G->arcs[i][j].adj = 0;
        }
    }
    for (int i = 0; i < G->arcnum; i++) {
        int v1, v2;
        scanf("%d,%d", &v1, &v2);
        int n = LocateVex(*G, v1);
        int m = LocateVex(*G, v2);
        if (m == -1 || n == -1) {
            printf("no this vertex\n");
            return;
        }
        G->arcs[n][m].adj = 1;
        G->arcs[m][n].adj = 1;
    }
}

int FirstAdjVex(MGraph G, int v) {
    for (int i = 0; i < G.vexnum; i++) {
        if (G.arcs[v][i].adj) {
            return i;
        }
    }
    return -1;
}

int NextAdjVex(MGraph G, int v, int w) {
    for (int i = w + 1; i < G.vexnum; i++) {
        if (G.arcs[v][i].adj) {
            return i;
        }
    }
    return -1;
}

void DFSTree(MGraph G, int v, CSTree *T) {
    visited[v] = true;
    bool first = true;
    CSTree q = NULL;
    for (int w = FirstAdjVex(G, v); w >= 0; w = NextAdjVex(G, v, w)) {
        if (!visited[w]) {
            CSTree p = (CSTree)malloc(sizeof(CSNode));
            p->data = G.vexs[w];
            p->lchild = NULL;
            p->nextsibling = NULL;
            if (first) {
                (*T)->lchild = p;
                first = false;
            } else {
                q->nextsibling = p;
            }
            q = p;
            DFSTree(G, w, &q);
        }
    }
}

void DFSForest(MGraph G, CSTree *T) {
    (*T) = NULL;
    for (int v = 0; v < G.vexnum; v++) {
        visited[v] = false;
    }
    CSTree q = NULL;
    for (int v = 0; v < G.vexnum; v++) {
        if (!(visited[v])) {
            CSTree p = (CSTree)malloc(sizeof(CSNode));
            p->data = G.vexs[v];
            p->lchild = NULL;
            p->nextsibling = NULL;
            if (!(*T)) {
                (*T) = p;
            } else {
                q->nextsibling = p;
            }
            q = p;
            DFSTree(G, v, &p);
        }
    }
}

void PreOrderTraverse(CSTree T) {
    if (T) {
        printf("%d ", T->data);
        PreOrderTraverse(T->lchild);
        PreOrderTraverse(T->nextsibling);
    }
    return;
}



/*

*/

typedef struct Queue{
    CSTree data;//队列中存放的为树结点
    struct Queue * next;
}Queue;

//初始化队列
void InitQueue(Queue ** Q){
    (*Q)=(Queue*)malloc(sizeof(Queue));
    (*Q)->next=NULL;
}
//结点v进队列
void EnQueue(Queue **Q,CSTree T){
    Queue * element=(Queue*)malloc(sizeof(Queue));
    element->data=T;
    element->next=NULL;
   
    Queue * temp=(*Q);
    while (temp->next!=NULL) {
        temp=temp->next;
    }
    temp->next=element;
}
//队头元素出队列
void DeQueue(Queue **Q,CSTree *u){
    (*u)=(*Q)->next->data;
    (*Q)->next=(*Q)->next->next;
}
//判断队列是否为空
bool QueueEmpty(Queue *Q){
    if (Q->next==NULL) {
        return true;
    }
    return false;
}

void BFSTree(MGraph G,int v,CSTree*T){
    CSTree q=NULL;
    Queue * Q;
    InitQueue(&Q);
    //根结点入队
    EnQueue(&Q, (*T));
    //当队列为空时，证明遍历完成
    while (!QueueEmpty(Q)) {
        bool first=true;
        //队列首个结点出队
        DeQueue(&Q,&q);
        //判断结点中的数据在数组中的具体位置
        int v = LocateVex(G,q->data);
        //已经访问过的更改其标志位
        visited[v]=true;
        //遍历以出队结点为起始点的所有邻接点
        for (int w=FirstAdjVex(G,v); w>=0; w=NextAdjVex(G,v, w)) {
            //标志位为false，证明未遍历过
            if (!visited[w]) {
                //新建一个结点 p，存放当前遍历的顶点
                CSTree p=(CSTree)malloc(sizeof(CSNode));
                p->data=G.vexs[w];
                p->lchild=NULL;
                p->nextsibling=NULL;
                //当前结点入队
                EnQueue(&Q, p);
                //更改标志位
                visited[w]=true;
                //如果是出队顶点的第一个邻接点，设置p结点为其左孩子
                if (first) {
                    q->lchild=p;
                    first=false;
                }
                //否则设置其为兄弟结点
                else{
                    q->nextsibling=p;
                }
                q=p;
            }
        }
    }
}
//广度优先搜索生成森林并转化为二叉树
void BFSForest(MGraph G,CSTree *T){
    (*T)=NULL;
    //每个顶点的标记为初始化为false
    for (int v=0; v<G.vexnum; v++) {
        visited[v]=false;
    }
    CSTree q=NULL;
    //遍历图中所有的顶点
    for (int v=0; v<G.vexnum; v++) {
        //如果该顶点的标记位为false，证明未访问过
        if (!(visited[v])) {
            //新建一个结点，表示该顶点
            CSTree p=(CSTree)malloc(sizeof(CSNode));
            p->data=G.vexs[v];
            p->lchild=NULL;
            p->nextsibling=NULL;
            //如果树未空，则该顶点作为树的树根
            if (!(*T)) {
                (*T)=p;
            }
            //该顶点作为树根的兄弟结点
            else{
                q->nextsibling=p;
            }
            //每次都要把q指针指向新的结点，为下次添加结点做铺垫
            q=p;
            //以该结点为起始点，构建广度优先生成树
            BFSTree(G,v,&p);
        }
    }
}



int main() {
    MGraph G;
    CreateDN(&G);
    CSTree T1;
    CSTree T2;
    DFSForest(G, &T1);
    BFSForest(G, &T2);
    PreOrderTraverse(T1);
    puts("");
    PreOrderTraverse(T2);
    system("pause");



    // CSTree T;
    // BFSForest(G, &T);
    // PreOrderTraverse(T);
    // return 0;
    return 0;
}