#include<bits/stdc++.h>
using namespace std;

#define forn(i,n) for(i=0;i<n;i++)
#define forin(i,s,n) for(i=s;i<n;i++)
#define revo(i,s) for(i=s;i>=0;i--)
#define rev(i,s,e) for(i=s;i>=e;i--)
#define pb push_back
#define mp make_pair
#define ll long long
#define endl "\n"
#define PI 3.14159265
#define a ar[0]
#define b ar[1]
#define c ar[2]
#define d ar[3]
#define int ll

signed main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    //Input Method Defined
    // freopen("input.txt", "r", stdin);
    // freopen("output.txt", "w", stdout);

    int ar[4];
    cin>>a>>b>>c>>d;
    sort(ar,ar+4);
    vector<vector<int>> v(c+1);
    map<int,int> m;
    int i,j;
    int total = 0;

    forin(i,1,c+1)
    {
        forin(j,i,d+1)
        {
            v[i].pb(i^j);
            m[i^j]++;
            total++;
        }
    }

    int sum = 0;

    forin(i,1,b+1)
    {
        forin(j,1,min(a,i)+1)
        {
            sum+=total - m[i^j];
        }

        total-=v[i].size();

        for(auto x:v[i])
            m[x]--;
    }

    cout<<sum;
}
