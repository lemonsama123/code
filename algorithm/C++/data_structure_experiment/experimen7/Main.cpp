#include <stdio.h>
#include <stdlib.h>
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
    scanf("%d,%d", &(G->vexnum), &(G->arcnum));
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

int main() {
    MGraph G;     
    CreateDN(&G); 
    CSTree T;
    DFSForest(G, &T);
    PreOrderTraverse(T);
    system("pause");
    return 0;
}