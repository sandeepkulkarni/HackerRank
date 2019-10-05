#include <bits/stdc++.h>

#define MAX 500
using namespace std;

int multiply(int res[],int res_size,int x)
{
    int carry=0;
    for(int i=0;i<res_size;i++)
    {
        int prod=x*res[i]+carry;
        res[i]=prod%10;
        carry=prod/10;;
    }   

    while(carry)
    {
        res[res_size]=carry%10;
        res_size++;
        carry/=10;
    }

    return res_size;
}

void factorial(int n)
{
    int res[MAX];
    int res_size=1;
    res[0]=1;
    for(int i=2;i<=n;i++)
        res_size=multiply(res,res_size,i);

    for(int i=res_size-1;i>=0;i--)
    cout<<res[i];
}


int main()
{
    int n;
    cin>>n;
    factorial(n);
    return 0;
}
