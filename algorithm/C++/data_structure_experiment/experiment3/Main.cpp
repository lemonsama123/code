#include <bits/stdc++.h>

using namespace std;

vector<string> preParse(char *str) {
    vector<string> tokens;
    int len = strlen(str);
    char *p = (char *)malloc((len + 1) * sizeof(char));
    int i = 0, j = 0;
    while (i < len) {
        if (str[i] == ' ') {
                i++;
                continue;
            }
        p[j++] = str[i++];
    }
    p[j] = '\0';
    j = 0;
    len = strlen(p);
    while (j < len) {
        char temp[2];
        string token;
        switch (p[j]) {
            case '+':
            case '*':
            case '/':
            case '(':
            case ')': {
                temp[0] = p[j];
                temp[1] = '\0';
                token = temp;
                tokens.push_back(token);
                break;
            }
            case '-': {
                if (p[j - 1] == ')' || isdigit(p[j - 1])) {
                    temp[0] = p[j];
                    temp[1] = '\0';
                    token = temp;
                    tokens.push_back(token);
                } else {
                    temp[0] = '#';
                    temp[1] = '\0';
                    token = temp;
                    tokens.push_back(token);
                }
                break;
            }
            default: {
                i = j;
                while (isdigit(p[i]) && i < len) {
                    i++;
                }
                char *opd = (char *)malloc(i - j + 1);
                strncpy(opd, p + j, i - j);
                opd[i - j] = '\0';
                token = opd;
                tokens.push_back(token);
                j = i - 1;
                free(opd);
                break;
            }
        }
        j++;
    }
    free(p);
    return tokens;
}

int getPriority(string opt) {
    int priority;
    if (opt == "#") {
        priority = 3;
    } else if (opt == "*" || opt == "/") {
        priority = 2;
    } else if (opt == "+" || opt == "-") {
        priority = 1;
    } else if (opt == "(") {
        priority = 0;
    }
    return priority;
}

void calculate(stack<int> &opdStack, string opt) {
    if (opt == "#") {
        int opd = opdStack.top();
        int result = 0 - opd;
        opdStack.pop();
        opdStack.push(result);
    } else if (opt == "+") {
        int rOpd = opdStack.top();
        opdStack.pop();
        int lOpd = opdStack.top();
        opdStack.pop();
        int result = lOpd + rOpd;
        opdStack.push(result);
    } else if (opt == "-") {
        int rOpd = opdStack.top();
        opdStack.pop();
        int lOpd = opdStack.top();
        opdStack.pop();
        int result = lOpd - rOpd;
        opdStack.push(result);
    } else if (opt == "*") {
        int rOpd = opdStack.top();
        opdStack.pop();
        int lOpd = opdStack.top();
        opdStack.pop();
        int result = lOpd * rOpd;
        opdStack.push(result);
    } else if (opt == "/") {
        int rOpd = opdStack.top();
        opdStack.pop();
        int lOpd = opdStack.top();
        opdStack.pop();
        int result = lOpd / rOpd;
        opdStack.push(result);
    }
}

int evaMidExpression(char *str) {
    vector<string> tokens = preParse(str);
    int i = 0;
    int size = tokens.size();

    stack<int> opdStack;    
    stack<string> optStack; 
    for (i = 0; i < size; i++) {
        string token = tokens[i];
        if (token == "#" || token == "+" || token == "-" || token == "*" || token == "/") {
            if (optStack.size() == 0) {
                optStack.push(token);
            } else {
                int tokenPriority = getPriority(token);
                string topOpt = optStack.top();
                int topOptPriority = getPriority(topOpt);
                if (tokenPriority > topOptPriority) {
                    optStack.push(token);
                } else {
                    while (tokenPriority <= topOptPriority) {
                        optStack.pop();
                        calculate(opdStack, topOpt);
                        if (optStack.size() > 0) {
                            topOpt = optStack.top();
                            topOptPriority = getPriority(topOpt);
                        }
                        else {
                            break;
                        }
                    }
                    optStack.push(token);
                }
            }
        } else if (token == "(") {
            optStack.push(token);
        } else if (token == ")") {
            while (optStack.top() != "(") {
                string topOpt = optStack.top();
                calculate(opdStack, topOpt);
                optStack.pop();
            }
            optStack.pop();
        } else {
            opdStack.push(atoi(token.c_str()));
        }
    }
    while (optStack.size() != 0) {
        string topOpt = optStack.top();
        calculate(opdStack, topOpt);
        optStack.pop();
    }
    return opdStack.top()  ;
}

int main() {
    char str[1000000];
    cin >> str;
    cout << evaMidExpression(str) << endl;
    system("pause");
    return 0;
}