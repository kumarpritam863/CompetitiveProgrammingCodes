import java.io.DataInputStream; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader; 
import java.util.*;

public class C{
	public static FastReader fs = new FastReader();
	
	static PrintWriter out = new PrintWriter(System.out);
	
	public static void solve() {
		StringBuffer output = new StringBuffer();
		int n = fs.nextInt();long x = fs.nextLong();
		long a [] = new long [n];
		for(int i = 0; i<n; i++)a[i] = fs.nextLong();
		int ans = 0;
		reverselongsort(a);
		//for(int i = 0; i<n; i++)out.println(a[i]);
		int i = 0;
		int count = 1;
		while(i < n) {
			if(ceil(x,a[i])<=count) {
				ans += 1;
				count = 1;
				i++;
			}
			else {
				i++;
				count++;
			}
		}
		output.append(ans);
		out.println(output);
	}
	
	public static void main(String[] args) {
		int t = 1;
		t = fs.nextInt();
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
	
	public static int ceil(int x,int y) {
		return (x % y == 0 ? x / y : (x / y +1));
	}
	
	public static long ceil(long x,long y) {
		return (x % y == 0 ? x / y : (x / y +1));
	}
	
	public static int max(int x,int y) {
		return Math.max(x, y);
	}
	
	public static int min(int x,int y) {
		return Math.min(x, y);
	}
	
	public static long max(long x,long y) {
		return Math.max(x, y);
	}
	
	public static long min(long x,long y) {
		return Math.min(x, y);
	}
	
	public static int power(int x,int y) {
		int res = 1;
		while(y > 0) {
			if( y % 2 == 1)res = (res * x);
			y >>= 1;
            x = (x * x);
		}
		return res;
	}
	
	public static long power(long x,long y) {
		long res = 1;
		while(y > 0) {
			if( y % 2 == 1)res = (res * x);
			y >>= 1;
            x = (x * x);
		}
		return res;
	}
	
	public static long power(long x,long y,long mod) {
		long res = 1;
		x %= mod;
		while(y > 0) {
			if( y % 2 == 1)res = (res * x) % mod;
			y >>= 1;
            x = (x * x) % mod;
		}
		return res;
	}
	
	public static void intsort(int [] a) {
		List<Integer> temp = new ArrayList<Integer>();
		for(int i = 0; i<a.length; i++)temp.add(a[i]);
		Collections.sort(temp);
		for(int i = 0; i<a.length; i++)a[i] = temp.get(i);
	}
	
	public static void longsort(long [] a) {
		List<Long> temp = new ArrayList<Long>();
		for(int i = 0; i<a.length; i++)temp.add(a[i]);
		Collections.sort(temp);
		for(int i = 0; i<a.length; i++)a[i] = temp.get(i);
	}
	
	public static void reverseintsort(int [] a) {
		List<Integer> temp = new ArrayList<Integer>();
		for(int i = 0; i<a.length; i++)temp.add(a[i]);
		Collections.sort(temp);
		Collections.reverseOrder();
		for(int i = 0; i<a.length; i++)a[i] = temp.get(i);
	}
	
	public static void reverselongsort(long [] a) {
		List<Long> temp = new ArrayList<Long>();
		for(int i = 0; i<a.length; i++)temp.add(a[i]);
		Collections.sort(temp);
		for(int i = a.length-1; i>=0; i--)a[a.length-1-i] = temp.get(i);
	}
	
	public static void intpairsort(intpair [] a) {
		List<intpair> temp = new ArrayList<intpair>();
		for(int i = 0; i<a.length; i++)temp.add(a[i]);
		Collections.sort(temp,(p1,p2) -> {
			if(p1.x == p2.x) return p1.y >= p2.y ? -1 : 1;
			else return p1.x > p2.x ? -1 : 1;
		});
		for(int i = 0; i<a.length; i++)a[i] = temp.get(i);
	}
	
	public static void longpairsort(longpair [] a) {
		List<longpair> temp = new ArrayList<longpair>();
		for(int i = 0; i<a.length; i++)temp.add(a[i]);
		Collections.sort(temp,(p1,p2) -> {
			if(p1.x == p2.x) return p1.y >= p2.y ? -1 : 1;
			else return p1.x > p2.x ? -1 : 1;
		});
		for(int i = 0; i<a.length; i++)a[i] = temp.get(i);
	}
	
	public static class intpair{
		public int x;
		public int y;
		
		intpair(int a,int b){
			this.x = a;
			this.y = b;
		}
		
		intpair(){}
	}
	
	public static class longpair{
		public long x;
		public long y;
		
		longpair(long a,long b){
			this.x = a;
			this.y = b;
		}
		
		longpair(){}
	}
	
	public static class data{
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
	
	public static class Seg_Tree extends data{
		public int n;
		long [] seg;
		
		Seg_Tree(int sz){
			this.n = sz;
			seg = new long[4*n+4];
		}
		
		void build(long a[], int v, int tl, int tr) {
		    if (tl == tr) {
		        seg[v] = a[tl];
		    } else {
		        int tm = (tl + tr) / 2;
		        build(a, v*2, tl, tm);
		        build(a, v*2+1, tm+1, tr);
		        seg[v] = seg[v*2]+seg[v*2+1];
		    }
		}

		void update(int v, int tl, int tr, int pos, long new_val) {
		    if (tl == tr) {
		        seg[v] = new_val;
		    } else {
		        int tm = (tl + tr) / 2;
		        if (pos <= tm)
		            update(v*2, tl, tm, pos, new_val);
		        else
		            update(v*2+1, tm+1, tr, pos, new_val);
		        seg[v] = seg[v*2]+seg[v*2+1];
		    }
		}
		
		long query(int v, int tl, int tr, int l, int r) {
		    if (l > r) 
		        return 0;
		    if (l == tl && r == tr) 
		        return seg[v];
		    int tm = (tl + tr) / 2;
		    return query(v*2, tl, tm, l, min(r, tm))+query(v*2+1, tm+1, tr, max(l, tm+1), r);
		}
	}
	
	public static class Bit_Tree{
		public static int n;
		public static int [] bit;
		
		Bit_Tree(int sz){
			Bit_Tree.n = sz;
			Bit_Tree.bit = new int[n+1];
		}
		
		public static int child(int x) {
			return x + (x & (-x));
		}
		
		public static int parent(int x) {
			return x - (x & (-x));
		}
		
		public static void build(int [] a) {
			for(int i = 0; i<a.length; i++) {
				int start = i+1;
				while(start <= n) {
					bit[start] += a[i];
					start = child(start);
				}
			}
		}
		
		public static void update(int idx,int new_val) {
			idx += 1;
			while(idx <= n) {
				bit[idx] += new_val;
				idx = child(idx);
			}
		}
		
		public static int query(int right) {
			int res = 0;
			while(right > 0) {
				res += bit[right];
				right = parent(right);
			}
			return res;
		}
		
		public static int query(int left,int right) {
			return query(right) - query(left-1);
		}
	}
}