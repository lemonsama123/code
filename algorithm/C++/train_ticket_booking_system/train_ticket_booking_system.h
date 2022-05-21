#ifndef TRAIN_TICKET_BOOKING_SYSTEM
#define TRAIN_TICKET_BOOKING_SYSTEM
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

typedef struct Passenger {//此结构体表示一个乘客的全部信息
    char id[100];//乘客id，具有唯一性
    char IDNo[100];//乘客身份证号
    char name[100];//乘客姓名
    int gd;//性别
    char telNum[100];//乘客电话号码
    char from[100];//出发地
    char to[100];//目的地
    char begin[100];//出发时间
    char end[100];//预计到达时间
    int isStudent;//是否是学生，1代表是，0代表不是
    char studentID[100];//学生id
    char school[100];//学生的学校
    float ticketPrice;//票价
    float discount;//学生享受的折扣，非学生此字段为0，最终票价=ticketPrice * (1 - discount)
} Passenger;

typedef struct Node {//此结构体表示单链表的的节点
    Passenger data;
    Node* next;
} Node;

/*==========链表相关操作==========*/
Node* initList();//创建一个带头节点的空链表
Node* newNode(Passenger passenger);//申请一个节点
void add(Node* head, Passenger passenger);//头插法插入节点
Node* find(Node* head, char id[]);//依据id查找节点
void printNodeInfo(Node* node);//打印一个节点的信息
void printList(Node* head);//打印链表
/*==========加载文件和保存文件模块==========*/
void load(Node* head);//将链表数据保存到文件中
void store(Node* head, int mode);//从文件中读取数据
// 乘客基本信息及学生购票信息的录入模块
void inInfo(Node* head);//从控制台输入乘客信息并加入单链表
// 乘客信息的管理模块
void update(Node* head, int mode);//修改信息 mode:1:修改基本信息，2:修改购票信息
void query(Node* head, int what);//0返回1按序号查询2按身份证号查询3按姓名查询
void statistics(Node* head);//统计乘客信息
void menu(Node* head);//打印菜单
void run();//程序入口
#endif