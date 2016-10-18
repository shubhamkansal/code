#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include"stack.h"

char openingof(char x)
{
    if(x == '}') return '{';
    if(x == ')') return '(';
    return '[';
}

int main()
{
    int n;
    scanf("%d", &n);
    char arr[n];
    scanf("%s", arr);
    int i;
    for(i = 0; i < n; i++)
    {
        if(arr[i] == '{' || arr[i] == '[' || arr[i] == '(')
            push((char *)arr[i]);
        else
            if( (char *)pop() != openingof(arr[i]) )
        {
            printf("not balanced\n");
            return 0;
        }
    }
    if(size() == 0)
        printf("balanced\n");
    else
        printf("not balanced\n");
    return 0;
}
