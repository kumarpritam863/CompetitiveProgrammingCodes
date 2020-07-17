import java.io.DataInputStream; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner; 
import java.util.StringTokenizer; 
import java.io.BufferedReader; 
import java.util.*;

interface nodeS<first,second>{
	first func(first x,second y);
}

class S{
	public static FastReader fs = new FastReader();
	static long mod = 1_000_000_00_7;
	static PrintWriter out = new PrintWriter(System.out);
	
	static void solve() {
		StringBuffer output = new StringBuffer();
		char k [] = fs.next().toCharArray();
		int d = fs.nextInt();
		long dp [][] = new long [d][2];
		dp[0][0] = 1;
		for(int where = 0; where < k.length; where++) {
			long dp1 [][] = new long[d][2];
			for(int sum = 0; sum < d; sum++) {
				for(int less : new int [] {0,1}) {
					for(int digit = 0; digit < 10; digit++) {
						if(digit > k[where]-'0' && less == 0)break;
						dp1[(digit+sum)%d][less | (digit < k[where] - '0' ? 1 : 0)] = (dp1[(digit+sum)%d][less | (digit < k[where] - '0' ? 1 : 0)]+dp[sum][less])%mod;
					}
				}
			}
			dp = dp1;
		}
		long ans = (dp[0][1] + dp[0][0])%mod;
		ans = (ans-1+mod)%mod;
		output.append(ans);
		out.println(output);
	}
	
	public static void main(String[] args) {
		int t = 1;
		//t = fs.nextInt();
		for(int cs = 1; cs <= t; cs++) {
			solve();
		}
		out.close();
	}
	
	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
	
	static int ceil(int x,int y) {
		return (x % y == 0 ? x / y : (x / y +1));
	}
	
	static long ceil(long x,long y) {
		return (x % y == 0 ? x / y : (x / y +1));
	}
	
	static int max(int x,int y) {
		return Math.max(x, y);
	}
	
	static int min(int x,int y) {
		return Math.min(x, y);
	}
	
	static long max(long x,long y) {
		return Math.max(x, y);
	}
	
	static long min(long x,long y) {
		return Math.min(x, y);
	}
	
	static int power(int x,int y) {
		int res = 1;
		while(y > 0) {
			if( y % 2 == 1)res = (res * x);
			y >>= 1;
            x = (x * x);
		}
		return res;
	}
	
	static long power(long x,long y) {
		long res = 1;
		while(y > 0) {
			if( y % 2 == 1)res = (res * x);
			y >>= 1;
            x = (x * x);
		}
		return res;
	}
	
	static long power(long x,long y,long mod) {
		long res = 1;
		x %= mod;
		while(y > 0) {
			if( y % 2 == 1)res = (res * x) % mod;
			y >>= 1;
            x = (x * x) % mod;
		}
		return res;
	}
	
	static void intsort(int [] a) {
		List<Integer> temp = new ArrayList<Integer>();
		for(int i = 0; i<a.length; i++)temp.add(a[i]);
		Collections.sort(temp);
		for(int i = 0; i<a.length; i++)a[i] = temp.get(i);
	}
	
	static void longsort(long [] a) {
		List<Long> temp = new ArrayList<Long>();
		for(int i = 0; i<a.length; i++)temp.add(a[i]);
		Collections.sort(temp);
		for(int i = 0; i<a.length; i++)a[i] = temp.get(i);
	}
	
	static void reverseintsort(int [] a) {
		List<Integer> temp = new ArrayList<Integer>();
		for(int i = 0; i<a.length; i++)temp.add(a[i]);
		Collections.sort(temp);
		Collections.reverseOrder();
		for(int i = 0; i<a.length; i++)a[i] = temp.get(i);
	}
	
	static void reverselongsort(long [] a) {
		List<Long> temp = new ArrayList<Long>();
		for(int i = 0; i<a.length; i++)temp.add(a[i]);
		Collections.sort(temp);
		Collections.reverseOrder();
		for(int i = 0; i<a.length; i++)a[i] = temp.get(i);
	}
	
	static void intpairsort(intpair [] a) {
		List<intpair> temp = new ArrayList<intpair>();
		for(int i = 0; i<a.length; i++)temp.add(a[i]);
		Collections.sort(temp,(p1,p2) -> {
			if(p1.x == p2.x) return p1.y >= p2.y ? -1 : 1;
			else return p1.x > p2.x ? -1 : 1;
		});
		for(int i = 0; i<a.length; i++)a[i] = temp.get(i);
	}
	
	static void longpairsort(longpair [] a) {
		List<longpair> temp = new ArrayList<longpair>();
		for(int i = 0; i<a.length; i++)temp.add(a[i]);
		Collections.sort(temp,(p1,p2) -> {
			if(p1.x == p2.x) return p1.y >= p2.y ? -1 : 1;
			else return p1.x > p2.x ? -1 : 1;
		});
		for(int i = 0; i<a.length; i++)a[i] = temp.get(i);
	}
	
	static class intpair{
		public int x;
		public int y;
		
		intpair(int a,int b){
			this.x = a;
			this.y = b;
		}
		
		intpair(){}
	}
	
	static class longpair{
		public long x;
		public long y;
		
		longpair(long a,long b){
			this.x = a;
			this.y = b;
		}
		
		longpair(){}
	}
	
	static class data{
		public long sum;
		
		data(long val){
		    this.sum = val;
		}
		
		data(){}
		
		data combine(data l, data r) {
		    data res = new data();
		    res.sum = l.sum + r.sum;
		    return res;
		}
	}
	
	static class Seg_Tree extends data{
		public int n;
		data [] seg;
		
		Seg_Tree(int sz){
			this.n = sz;
			seg = new data[4*n+4];
		}
		
		void build(long a[], int v, int tl, int tr) {
		    if (tl == tr) {
		        seg[v] = new data(a[tl]);
		    } else {
		        int tm = (tl + tr) / 2;
		        build(a, v*2, tl, tm);
		        build(a, v*2+1, tm+1, tr);
		        seg[v] = combine(seg[v*2],seg[v*2+1]);
		    }
		}

		void update(int v, int tl, int tr, int pos, long new_val) {
		    if (tl == tr) {
		        seg[v] = new data(new_val);
		    } else {
		        int tm = (tl + tr) / 2;
		        if (pos <= tm)
		            update(v*2, tl, tm, pos, new_val);
		        else
		            update(v*2+1, tm+1, tr, pos, new_val);
		        seg[v] = combine(seg[v*2],seg[v*2+1]);
		    }
		}
		
		data query(int v, int tl, int tr, int l, int r) {
		    if (l > r) 
		        return new data(0);
		    if (l == tl && r == tr) 
		        return seg[v];
		    int tm = (tl + tr) / 2;
		    return combine(query(v*2, tl, tm, l, min(r, tm)),query(v*2+1, tm+1, tr, max(l, tm+1), r));
		}
	}
	
	static class Bit_Tree{
		static int n;
		static int [] bit;
		
		Bit_Tree(int sz){
			Bit_Tree.n = sz;
			Bit_Tree.bit = new int[n+1];
		}
		
		static int child(int x) {
			return x + (x & (-x));
		}
		
		static int parent(int x) {
			return x - (x & (-x));
		}
		
		static void build(int [] a) {
			for(int i = 0; i<a.length; i++) {
				int start = i+1;
				while(start <= n) {
					bit[start] += a[i];
					start = child(start);
				}
			}
		}
		
		static void update(int idx,int new_val) {
			idx += 1;
			while(idx <= n) {
				bit[idx] += new_val;
				idx = child(idx);
			}
		}
		
		static int query(int right) {
			int res = 0;
			while(right > 0) {
				res += bit[right];
				right = parent(right);
			}
			return res;
		}
		
		static int query(int left,int right) {
			return query(right) - query(left-1);
		}
	}
}