#include <bits/stdc++.h>

using namespace std;

typedef struct BSTNode {
	int data;
	BSTNode *lchild; //左孩子
	BSTNode *rchild; //右孩子
} BSTNode, *BSTree;

bool search(BSTree bst, int key, BSTree f, BSTree *p) {
	if (!bst) {
		*p = f;
		return false;
	}
	if (bst->data == key) {
		*p = bst;
		return true;
	} else if (bst->data < key) {
		return search(bst->rchild, key, bst, p);
	}
	return search(bst->lchild, key, bst, p);
}

void inOderTraverse(BSTree bst) { //中序递归
	if (bst != nullptr) {
		inOderTraverse(bst->lchild);
		printf("%d ", bst->data);
		inOderTraverse(bst->rchild);
	}
}

static BSTNode *buyNode(int data) { //生成一个节点并进行初始化
	BSTNode *pTmp = (BSTNode *)malloc(sizeof(BSTNode));
	if (pTmp  ==  nullptr) {
		exit(0);
	}
	pTmp->data = data;
	pTmp->lchild = nullptr;
	pTmp->rchild = nullptr;
	return pTmp;
}

bool insert(BSTree *bst, int key) {
	if (nullptr == *bst) {
		*bst = buyNode(key); 
		return true;
	}
	BSTNode *p;
	if (!search(*bst, key, nullptr, &p)) {
		BSTNode *pNew = buyNode(key);
		if (key < p->data) {
			p->lchild = pNew;
		} else if (key > p->data) {
			p->rchild = pNew;
		}
		return true;
	} else {
		printf("\nThe node(%d) already exists.\n", key);
	}
	return false;
}

/*
删除分三种情况：
(1)被删除的节点无孩子，说明该节点是叶子节点，直接删
(2)被删除的节点只有左孩子或者右孩子，直接删，并将其左孩子或者右孩子放在被删节点的位置
(3)被删除的节点既有右孩子又有右孩子
*/

BSTNode *FindParent(BSTree bst, BSTNode *child) {
	if (nullptr == bst) {
		return nullptr;
	}
	if (bst->lchild == child || bst->rchild == child) {
		return bst;
	} else if (nullptr != bst->lchild) {
		FindParent(bst->lchild, child);
	} else if (nullptr != bst->rchild) {
		FindParent(bst->rchild, child);
	}
}

void Delete(BSTree *bst, int key) {
	if (nullptr == *bst) {
		return; 
	} 
	BSTNode *p;
	BSTNode *f = nullptr;
	BSTNode *q, *s;
	if (search(*bst, key, nullptr, &p)) { 
		if (nullptr == p->lchild && nullptr != p->rchild) { //无左孩子,有右孩子
			q = p->rchild;
			p->data = q->data; //因为两个节点之间本质的不同在于数据域的不同，而与放在哪个地址没有关系
			p->rchild = q->rchild;
			p->lchild = q->lchild;
			free(q);
		} else if (nullptr == p->rchild && nullptr != p->lchild) {
			q = p->lchild;
			p->data = q->data;
			p->rchild = q->rchild;
			p->lchild = q->lchild;
			free(q);
		} else if (nullptr != p->rchild && nullptr != p->lchild) {
			q = p;
			s = p->lchild; //找左孩子的最右孩子
			while (s->rchild) {
				q = s;
				s = s->rchild;
			}
			p->data = s->data;
			if (q != p) {
				q->rchild = p->lchild;
			} else {
				q->lchild = s->lchild;
			}
			free(s);
		} else {
			if (*bst == p) {
				free(*bst);
				*bst = nullptr;
				return;
			}
			BSTNode *parent = FindParent(*bst, p);
			if (parent->lchild == p) {
				parent->lchild = nullptr;
			} else {
				parent->rchild = nullptr;
			}
			free(p);
		}
	}
}

int main(void) {
	BSTNode *root = nullptr;
	insert(&root, 45);
	insert(&root, 24);
	insert(&root, 53);
	insert(&root, 12);
	insert(&root, 90);
	inOderTraverse(root);
	printf("\n%d ", insert(&root, 45)); //输出0表示插入失败，输出1表示插入成功
	printf("%d\n", insert(&root, 4));
	inOderTraverse(root);
	printf("\n");
	Delete(&root, 4);  //删除节点45
	Delete(&root, 45); //删除节点45
	Delete(&root, 24); //删除节点45
	Delete(&root, 53); //删除节点45
	Delete(&root, 12); //删除节点45
	Delete(&root, 90); //删除节点45
	inOderTraverse(root);
	system("pause");
	return 0;
}