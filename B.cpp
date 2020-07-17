#include <bits/stdc++.h>
using namespace std;
#define li          long
#define ll          long long
#define ull         unsigned long long
#define ff          first
#define ss          second
#define pii         pair<int,int>
#define pli         pair<li,li>
#define pll         pair<ll,ll>
#define pb          push_back
#define fo(i,k,n)   for(int i = k;i<n; i++)
#define ro(i,k,n)   for(int i = k; i>=n; i--)
#define tc          int t;cin>>t;while(t--)
#define all(v)      v.begin(),v.end()
#define inf         INT_MAX
#define ninf        INT_MIN
#define W(x)        cout<<x<<endl
#define WW(x,y)     cout<<x<<' '<<y<<endl;
#define in(x)       cin>>x
#define v(x)        vector<x>
#define int         long long
#define ar(x,y)     array<x,y>
const ll mod1 = 99844353;
const ll mod2 = 1e9+7;
/* template <class T>
using oset = tree<T,null_type,less<T>,rb_tree_tag,tree_order_statistics_node_update>; */

void fastio()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
}

template<class T>
T power(T a,T b){
    T res = (T)1;
    while(b>0){
        if(b&1)res = res*a;
        b>>=1;
        a*=a;
    }
    return res;
}

struct dsu{
  unordered_map<int,int> pr,sz;
  dsu(){
    (this->pr).clear();
    (this->sz).clear();
  }
  void make(int x){
    pr[x] = x;
    sz[x] = 1;
  }
  int getpar(int x){
    if(pr[x] == x)return x;
    return pr[x] = getpar(pr[x]);
  }
  void merge(int x,int y){
    x = getpar(x);
    y = getpar(y);
    if(sz[x]<sz[y])swap(x,y);
    pr[y] = x;
    sz[x]+=sz[y];
    sz[y] = 0;
  }
};

int n,x;

class data{
public:
  int count;

		data(int val){
		    this->count = (val == x ? 1 : 0);
		}

		data(){}
};

class Seg_Tree{
public:
  int n;
	vector<data> seg;

		Seg_Tree(int sz){
			this->n = sz;
			this->seg.resize(4*n);
		}
    data combine(data l, data r) {
        data res;
        res.count = l.count + r.count;
        return res;
    }

		void build(int a[], int v, int tl, int tr) {
		    if (tl == tr) {
		        seg[v] = data(a[tl]);
		    } else {
		        int tm = (tl + tr) / 2;
		        build(a, v*2, tl, tm);
		        build(a, v*2+1, tm+1, tr);
		        seg[v] = combine(seg[v*2], seg[v*2+1]);
		    }
		}

		void update(int v, int tl, int tr, int pos, int new_val) {
		    if (tl == tr) {
		        seg[v] = data(new_val);
		    } else {
		        int tm = (tl + tr) / 2;
		        if (pos <= tm)
		            update(v*2, tl, tm, pos, new_val);
		        else
		            update(v*2+1, tm+1, tr, pos, new_val);
		        seg[v] = combine(seg[v*2], seg[v*2+1]);
		    }
		}

		data query(int v, int tl, int tr, int l, int r) {
		    if (l > r)
		        return data(0);
		    if (l == tl && r == tr)
		        return seg[v];
		    int tm = (tl + tr) / 2;
		    return combine(query(v*2, tl, tm, l, min(r, tm)),
		                   query(v*2+1, tm+1, tr, max(l, tm+1), r));
		}
		int find_kth(int v, int tl, int tr, int k) {
		    if (k > seg[v].count)
		        return -1;
		    if (tl == tr)
		        return tl;
		    int tm = (tl + tr) / 2;
		    if (seg[v*2].count >= k)
		        return find_kth(v*2, tl, tm, k);
		    else
		        return find_kth(v*2+1, tm+1, tr, k - seg[v*2].count);
		}
};

void solve(){
  int k,x,y;
  cin>>k;
  vector<int> a(k);
  cin>>x;
  a[0] = 0;
  for(int i=1;i<k;i++) {
      cin>>y;
      if(y>x)
          a[i] = a[i-1] + 1;
      else if(y==x)
          a[i] = a[i-1];
      else
          a[i] = a[i-1] - 1;
      x = y;
  }
  int cnt = 0;
  int min = a[0];
  int max = a[0];
  for(int i=0;i<k;i++) {
      if((a[i])<min)
          min = a[i];
      if((a[i])>max)
          max = a[i];
      if(max-min >= 4) {
          cnt ++;
          min = (a[i]);
          max = (a[i]);
      }
  }
  cout<<cnt<<"\n";
}

signed main(){
    fastio();
    int t;
    cin>>t;
    for(int cs = 1; cs<=t; cs++){
      cout << "Case #" << cs << ": ";
      solve();
    }
}
