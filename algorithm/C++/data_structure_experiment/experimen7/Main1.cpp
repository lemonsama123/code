

int main() {
    MGraph G;//建立一个图的变量
    CreateDN(&G);//初始化图
    CSTree T;
    BFSForest(G, &T);
    PreOrderTraverse(T);
    return 0;
}