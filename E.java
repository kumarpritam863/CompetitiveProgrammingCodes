import java.io.DataInputStream; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner; 
import java.util.StringTokenizer; 
import java.io.BufferedReader; 
import java.util.*;

class E{
	public static FastReader fs = new FastReader();
	
	static PrintWriter out = new PrintWriter(System.out);
	
	public static void solve() {
		StringBuffer output = new StringBuffer();
		int n = fs.nextInt(),q = fs.nextInt();
		long a_0 [] = new long [n];
		long a_1 [] = new long [n];
		long a_2 [] = new long [n];
		for(int i = 0; i<n; i++) {
			long x = fs.nextLong();
			if(i % 2 == 0) {
				a_0[i] = x;
				a_1[i] = (i+1)*x;
				a_2[i] = -(i+1)*x;
			}
			else {
				a_0[i] = -x;
				a_1[i] = -(i+1)*x;
				a_2[i] = (i+1)*x;
			}
		}
		Seg_Tree seg [] = new Seg_Tree[3];
		for(int i = 0; i<3; i++)seg[i] = new Seg_Tree(n);
		seg[0].build(a_0, 1, 0, n-1);
		seg[1].build(a_1, 1, 0, n-1);
		seg[2].build(a_2, 1, 0, n-1);
		long ans = 0;
		for(int qry = 0; qry < q; qry++) {
			char type = fs.next().charAt(0);
			if(type == 'U') {
				int index = fs.nextInt();
				long val = fs.nextLong();
				index -= 1;
				if(index % 2 == 0) {
					seg[0].update(1, 0, n-1, index, val);
					seg[1].update(1, 0, n-1, index, (index+1)*val);
					seg[2].update(1, 0, n-1, index, -(index+1)*val);
				}
				else {
					seg[0].update(1, 0, n-1, index, -val);
					seg[1].update(1, 0, n-1, index, -(index+1)*val);
					seg[2].update(1, 0, n-1, index, (index+1)*val);
				}
			}
			else {
				int l = fs.nextInt(),r = fs.nextInt();
				l-=1;r-=1;
				if(l % 2 == 0) {
					ans += seg[1].query(1, 0, n-1, l, r).sum;
					ans -= (l >= 0 ? l : 0)*(seg[0].query(1, 0, n-1, l, r).sum);
				}
				else {
					ans += seg[2].query(1, 0, n-1, l, r).sum;
					ans += (l >= 0 ? l : 0)*(seg[0].query(1, 0, n-1, l, r).sum);
				}
			}
		}
		output.append(ans);
		out.println(output);
	}
	
	public static void main(String[] args) {
		int t = 1;
		t = fs.nextInt();
		for(int cs = 1; cs <= t; cs++) {
			StringBuffer template = new StringBuffer();
			template.append("Case #" + cs + ": ");
			out.print(template);
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
		Collections.reverse(temp);
		for(int i = 0; i<a.length; i++)a[i] = temp.get(i);
	}
	
	public static void reverselongsort(long [] a) {
		List<Long> temp = new ArrayList<Long>();
		for(int i = 0; i<a.length; i++)temp.add(a[i]);
		Collections.sort(temp);
		Collections.reverse(temp);
		for(int i = 0; i<a.length; i++)a[i] = temp.get(i);
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
		    return new data(l.sum + r.sum);
		}
	}
	
	static class Seg_Tree extends data{
		public int n;
		data [] seg;
		
		Seg_Tree(int sz){
			this.n = sz;
			seg = new data[4*n];
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