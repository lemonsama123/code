#include "train_ticket_booking_system.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

Node* initList() {
    Node* head;
    head = (Node*) malloc(sizeof(Node));
    head->next = NULL;
    return head;
}

Node* newNode(Passenger passenger) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->data = passenger;
    newNode->next = NULL;
    return newNode;
}

void add(Node* head, Passenger passenger) {
    Node* temp = head;
    Node* newN = newNode(passenger);
    if (!temp->next) {
        temp->next = newN;
    } else {
        newN->next = head->next;
        head->next = newN;
    }
}

Node* find(Node* head, char id[]) {
    Node* temp = head->next;
    while (temp) {
        if (!strcmp(id, temp->data.id)) {
            return temp;
        }
        temp = temp->next;
    }
    return NULL;
}

void printNodeInfo(Node* node) {
    printf("|%s ", node->data.id);
    printf("|%s ", node->data.IDNo);
    printf("|%4s", (node->data.gd ? "男" : "女"));
    printf("|%5s\t", node->data.name); 
    printf("|%s\t", node->data.telNum), 
    printf("|%11s|", node->data.from);
    printf("%11s|", node->data.to);
    printf("%s   ", node->data.begin);
    printf("|%s        ", node->data.end);
    printf("|%.2f\t", node->data.ticketPrice);
    printf("|%6s       ", node->data.isStudent ? "是" : "否");
    printf("|%12s ", node->data.school);
    printf("|%12s ", node->data.studentID);
    printf("|%6.2f  ", node->data.discount);
    printf("|%6.2f  |\n", node->data.ticketPrice * (1.0f - node->data.discount));
}

void printList(Node* head) {
    Node* temp = head->next;
    printf("____________________________________________________________________________________________________________________________________________________________________________\n");
    printf("|序号  |身份证号           |性别|姓名   |手机号         |出发地     |目的地     |出发时间|预计到达时间 |原票价  |是否为学生票 |        学校 |        学号 |学生折扣|最终票价|\n");
    while (temp != NULL) {
        printNodeInfo(temp);
        temp = temp->next;
    }
}

void load(Node* head) {
    FILE* fp = fopen("info", "r");
    char buff[1024] = {'\0'};
    while (fscanf(fp, "%s", buff) != EOF) {
        Passenger passenger;
        strcpy(passenger.id, buff);
        fscanf(fp, "%s", buff);
        strcpy(passenger.IDNo, buff);
        fscanf(fp, "%s", buff);
        passenger.gd = buff[0] - '0';
        fscanf(fp, "%s", buff);
        strcpy(passenger.name, buff);
        fscanf(fp, "%s", buff);
        strcpy(passenger.telNum, buff);
        fscanf(fp, "%s", buff);
        strcpy(passenger.from, buff);
        fscanf(fp, "%s", buff);
        strcpy(passenger.to, buff);
        fscanf(fp, "%s", buff);
        strcpy(passenger.begin, buff);
        fscanf(fp, "%s", buff);
        strcpy(passenger.end, buff);
        fscanf(fp, "%s", buff);
        passenger.ticketPrice = atof(buff);
        fscanf(fp, "%s", buff);
        passenger.isStudent = buff[0] - '0';
        fscanf(fp, "%s", buff);
        strcpy(passenger.school, buff);
        fscanf(fp, "%s", buff);
        strcpy(passenger.studentID, buff);
        fscanf(fp, "%s", buff);
        passenger.discount = atof(buff);
        add(head, passenger);
    }
    fclose(fp);
}

void store(Node* head, int mode) {
    Node* temp = head->next;
    FILE* fp = NULL;
    if (mode == 1) {
        fp = fopen("info", "a");
    } else if (mode == 2) {
        fp = fopen("info", "w");
    }
    char conts[1024] = {'\0'};
    char str[100];
    while (temp) {
        strcat(conts, temp->data.id);
        strcat(conts, " ");
        strcat(conts, temp->data.IDNo);
        strcat(conts, " ");
        memset(str, 0, sizeof(str));
        itoa(temp->data.gd, str, 10);
        strcat(conts, str);
        strcat(conts, " ");
        strcat(conts, temp->data.name);  
        strcat(conts, " ");
        strcat(conts, temp->data.telNum);
        strcat(conts, " ");
        strcat(conts, temp->data.from);
        strcat(conts, " ");
        strcat(conts, temp->data.to);
        strcat(conts, " ");
        strcat(conts, temp->data.begin);
        strcat(conts, " ");
        strcat(conts, temp->data.end);
        memset(str, 0, sizeof(str));
        sprintf(str, "%.2f", temp->data.ticketPrice);
        strcat(conts, " ");
        strcat(conts, str);
        strcat(conts, " ");
        memset(str, 0, sizeof(str));
        itoa(temp->data.isStudent, str, 10);
        strcat(conts, str);
        strcat(conts, " ");
        strcat(conts, temp->data.school);
        strcat(conts, " ");
        strcat(conts, temp->data.studentID);
        memset(str, 0, sizeof(str));
        sprintf(str, "%.2f",  temp->data.discount);
        strcat(conts, " ");
        strcat(conts, str);
        strcat(conts, "\n");
        fputs(conts, fp);
        temp = temp->next;
    }
    fclose(fp);
}

void inInfo(Node* head) {
    Passenger passenger;
    printf("请输入序号：");
    scanf("%s", passenger.id);
    printf("\n请输入身份证号：");
    scanf("%s", passenger.IDNo);
    printf("\n请输入性别（男：1，女：0）：");
    scanf("%d", &passenger.gd);
    getchar();
    printf("\n请输入姓名：");
    scanf("%s", passenger.name);
    printf("\n请输入手机号：");
    scanf("%s", passenger.telNum);
    printf("\n请输入出发地：");
    scanf("%s", passenger.from);
    printf("\n请输入目的地：");
    scanf("%s", passenger.to);
    printf("\n请输入出发时间：");
    scanf("%s", passenger.begin);
    printf("\n请输入预计到达时间：");
    scanf("%s", passenger.end);
    printf("\n请输入票价：");
    scanf("%f", &passenger.ticketPrice);
    getchar();
    printf("\n是否是学生购票（是：1，否：0）：");
    scanf("%d", &passenger.isStudent);
    // getchar();
    if (passenger.isStudent) {
        printf("\n请输入学校：");
        scanf("%s", passenger.school);
        printf("\n请输入学号：");
        scanf("%s", passenger.studentID);
        printf("请输入学生折扣：");
        scanf("%f", &passenger.discount);
        // getchar();
    } else {
        strcpy(passenger.school, "无");
        strcpy(passenger.studentID, "无");
        passenger.discount = 0.0;
    }
    add(head, passenger);
}

void update(Node* head, int mode) {
    if (mode == 1) {
        char str[100];
        printf("请输入要修改的乘客的id：");
        scanf("%s", str);
        Node* found = find(head, str);
        char op[2];
        printf("是否需要修改身份证号？（y/n）");
        scanf("%s", op);
        if (op[0] == 'y') {
            printf("请输入新身份证号：");
            scanf("%s", str);
            strcpy(found->data.IDNo, str);
        }
        printf("是否需要修改姓名？（y/n）");
        scanf("%s", op);
        if (op[0] == 'y') {
            printf("请输入新姓名：");
            scanf("%s", str);
            strcpy(found->data.name, str);
        }
        printf("是否需要修改电话号码？（y/n）");
        scanf("%s", op);
        if (op[0] == 'y') {
            printf("请输入电话号码：");
            scanf("%s", str);
            strcpy(found->data.telNum, str);
        }
        printf("是否需要修改性别？（y/n）");
        scanf("%s", op);
        if (op[0] == 'y') {
            printf("请输入电话号码：");
            scanf("%s", str);
            found->data.gd = str[0] - '0';
        }
    } else if (mode == 2) {
        char str[100];
        printf("请输入要修改的乘客的id：");
        scanf("%s", str);
        Node* found = find(head, str);
        char op[2];
        printf("是否需要修改出发地？（y/n）");
        scanf("%s", op);
        if (op[0] == 'y') {
            printf("请输入新出发地：");
            scanf("%s", str);
            strcpy(found->data.from, str);
        }
        printf("是否需要修改目的地？（y/n）");
        scanf("%s", op);
        if (op[0] == 'y') {
            printf("请输入新目的地：");
            scanf("%s", str);
            strcpy(found->data.to, str);
        }
        printf("是否需要修改出发时间？（y/n）");
        scanf("%s", op);
        if (op[0] == 'y') {
            printf("请输入新的出发时间：");
            scanf("%s", str);
            strcpy(found->data.begin, str);
        }
        printf("是否需要修改预计达到时间？（y/n）");
        scanf("%s", op);
        if (op[0] == 'y') {
            printf("请输入新的预计达到时间：");
            scanf("%s", str);
            strcpy(found->data.end, str);
        }
        printf("是否需要修改学生购票信息？（y/n）");
        scanf("%s", op);
        if (op[0] == 'y') {
            int isStudent;
            printf("是否为学生？（是：1，否：0）");
            if (!isStudent) {
                found->data.isStudent = 0;
            } else {
                found->data.isStudent = 1;
                printf("请输入学校：");
                scanf("%s", str);
                strcpy(found->data.school, str);
                printf("请输入学号");
                scanf("%s", str);
                strcpy(found->data.studentID, str);
                printf("请输入学生折扣");
                scanf("%f", found->data.discount);
            }
        }
    }
}

void query(Node* head, int what) {//0返回1序号2身份证号3姓名
    Node* temp = head->next;
    if (what == 1) {
        char str[20];
        printf("请输入要查询的乘客的序号：");
        scanf("%s", str);
        while (temp != NULL) {
            if (!strcmp(temp->data.id, str)) {
                printNodeInfo(temp);
                break;
            }
            temp = temp->next;
        }
        printf("查询完毕，下一步做什么？（返回：0，按重新序号：1，按身份证号重新查询：2，按姓名重新：3）");
        int nextWhat;
        scanf("%d", &nextWhat);
        query(head, nextWhat);
    } else if (what == 2) {
        char str[30];
        printf("请输入要查询的身份证号：");
        scanf("%s", str);
        while (temp != NULL) {
            if (!strcmp(temp->data.name, str)) {
                printNodeInfo(temp);
                break;
            }
            temp = temp->next;
        }
        printf("查询完毕，下一步做什么？（返回：0，按重新序号：1，按身份证号重新查询：2，按姓名重新：3）");
        int nextWhat;
        scanf("%d", &nextWhat);
        query(head, nextWhat);
    } else if (what == 3) {
        char str[20];
        printf("请输入要查询的姓名：");
        scanf("%s", str);
        while (temp != NULL) {
            if (!strcmp(temp->data.name, str)) {
                printNodeInfo(temp);
            }
            temp = temp->next;
        }
        printf("查询完毕，下一步做什么？（返回：0，按重新序号：1，按身份证号重新查询：2，按姓名重新：3）");
        int nextWhat;
        scanf("%d", &nextWhat);
        query(head, nextWhat);
    } else if (what == 0) {
        return;
    } else {
        printf("没有这样的操作，请重新输入（返回：0，按重新序号：1，按身份证号重新查询：2，按姓名重新：3）");
        int nextWhat;
        scanf("%d", &nextWhat);
        query(head, nextWhat);
    }
}

void statistics(Node* head) {
    int count = 0;
    int isStu = 0;
    Node* temp = head->next;
    while (temp) {
        isStu += (temp->data.isStudent);
        ++count;
        temp = temp->next;
    }
    printList(head);
    printf("学生：%d人，总人数：%d人\n", isStu, count);
    printf("查询完毕，回车返回\n");
    getchar();
    getchar();
}

void menu(Node* head) {
    while (1) {
        printf("********************************\n");
        printf("**    欢迎使用火车票管理系统  **\n");
        printf("********************************\n");
        printf("*       1.录入乘客信息         *\n");
        printf("*       2.管理乘客基本信息     *\n");
        printf("*       3.管理乘客购票信息     *\n");
        printf("*       4.查询乘客信息         *\n");
        printf("*       5.乘客信息统计         *\n");
        printf("*       6.保存操作             *\n");
        printf("*       7.退出系统             *\n");
        printf("********************************\n");
        int selected;
        scanf("%d", &selected);
        if (selected == 1) {
            printf("请输入要录入的乘客信息的数量：");
            int n;
            scanf("%d", &n);
            for (int i = 1; i <= n;++i) {
                printf("****************第%2d个乘客的信息************\n", i);
                inInfo(head);
            }
        } else if (selected == 2) {
            update(head, 1);
        } else if (selected == 3) {
            update(head, 2);
        } else if (selected == 4) {
            printf("按什么关键字查询？（序号：1，身份证号：2，姓名：3）");
            int what;
            scanf("%d", &what);
            query(head, what);
        } else if (selected == 5) {
            statistics(head);
        } else if (selected == 6) {
            printf("请输入保存的模式：（追加：1，覆盖：2）");
            int mode;
            scanf("%d", &mode);
            store(head, mode);
        } else if (selected == 7) {
            printf("退出之前是否保存？（y/n）");
            getchar();
            char op[2];
            scanf("%c", op);
            if (op[0] == 'y') {
                printf("请输入保存的模式：（追加：1，覆盖：2）");
                int mode;
                scanf("%d", &mode);
                store(head, mode);
                printf("保存成功：再见！");
            } else {
                printf("再见！");
                return;
            }
        }
    }
}

void run() {
    Node* head = initList();
    load(head);
    menu(head);
}

int main() {
    run();
    system("pause");
    return 0;
}