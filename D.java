import java.io.DataInputStream; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner; 
import java.util.StringTokenizer; 
import java.io.BufferedReader; 
import java.util.*;

public class D{
	public static FastReader fs = new FastReader();
	
	static PrintWriter out = new PrintWriter(System.out);
	
	/*
	 * static long forb(int l,int r,int k,int a[]) { int mx = -1; for(int i = l+1;
	 * i<r; i++)mx = max(mx,a[i]); boolean oktodel = false; if(a[l] > mx || a[r] >
	 * mx)oktodel = true; }
	 */
	
	public static void solve() {
		StringBuffer output = new StringBuffer();
		int n = fs.nextInt(),m = fs.nextInt();
		long x = fs.nextLong(),k = fs.nextLong(),y = fs.nextLong();
		Map<Integer,Integer> mp = new HashMap<Integer,Integer>();
		int a [] = new int [n];
		int b [] = new int [m];
		ArrayList<Integer> removed = new ArrayList<Integer>();
		for(int i = 0; i<n; i++) {
			a[i] = fs.nextInt();
			mp.put(a[i], i);
		}
		Seg_Tree seg = new Seg_Tree(n);
		seg.build(a, 1, 0, n-1);
		//removed.add(0);
		for(int i = 0; i<m; i++) {
			b[i] = fs.nextInt();
			removed.add(mp.get(b[i]));
		}
		//removed.add(n-1);
		long ans = 0;
		for(int i = 1; i<removed.size(); i++) {
			int start = removed.get(i-1);
			int end = removed.get(i);
			int sz = end-start-1;
			if(start > end) {
				output.append("-1");
				out.println(output);
				return;
			}
			int mx = seg.max_query(1, 0, n-1, start+1, end-1);
			if(sz < k) {
				if(mx>a[start] && mx > a[end]) {
					output.append("-1");
					out.println(output);
					return;
				}
				else {
					ans += (long)sz*(long)y;
				}
			}
			else {
				ans += (long)(sz%k) * (long)y;
				sz -= sz%k;
				if(k*y >= x)ans += (sz/k)*x;
				else if(mx > a[start] && mx > a[end])ans += (long)(sz - k) * (long)y + (long)x;
				else ans += (long)sz * (long)y;
			}
		}
		if(removed.get(0)!=0) {
			int first = removed.get(0);
			int sz = first;
			int mx = seg.max_query(1, 0, n-1, 0, first-1);
				if(sz < k) {
					if(mx> a[first]) {
						output.append("-1");
						out.println(output);
						return;
					}
					else {
						ans += (long)sz*(long)y;
					}
				}
				else {
					ans += (long)(sz%k) * (long)y;
					sz -= sz%k;
					if(k*y >= x)ans += (sz/k)*x;
					else if(mx > a[first])ans += (long)(sz - k) * (long)y + (long)x;
					else ans += (long)sz * (long)y;
				}
		}
		if(removed.get(removed.size()-1)!=n-1) {
			int first = removed.get(removed.size()-1);
			int sz = n-1-first;
			int mx = seg.max_query(1, 0, n-1, first+1, n-1);
			
				if(sz < k) {
					if(mx> a[first]) {
						output.append("-1");
						out.println(output);
						return;
					}
					else {
						ans += (long)sz*(long)y;
					}
				}
				else {
					ans += (long)(sz%k) * (long)y;
					sz -= sz%k;
					if(k*y >= x)ans += (sz/k)*x;
					else if(mx > a[first])ans += (long)(sz - k) * (long)y + (long)x;
					else ans += (long)sz * (long)y;
				}
		}
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
		Collections.reverseOrder();
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
		public int val;
		
		data(int val){
		    this.val = val;
		}
		
		data(){}
		
		data combine(data l, data r) {
		    data res = new data();
		    res.val = max(l.val , r.val);
		    return res;
		}
	}
	
	public static class Seg_Tree extends data{
		public int n;
		int seg_max [];
		int seg_min [];
		
		Seg_Tree(int sz){
			this.n = sz;
			seg_max = new int[4*n+4];
			seg_min = new int[4*n+4];
		}
		
		void build(int a[], int v, int tl, int tr) {
		    if (tl == tr) {
		        seg_max[v] = seg_min[v] =  a[tl];
		    } else {
		        int tm = (tl + tr) / 2;
		        build(a, v*2, tl, tm);
		        build(a, v*2+1, tm+1, tr);
		        seg_max[v] = max(seg_max[v*2],seg_max[v*2+1]);
		        seg_min[v] = min(seg_min[v*2],seg_max[v*2+1]);
		    }
		}

		void update(int v, int tl, int tr, int pos, int new_val) {
		    if (tl == tr) {
		    	seg_max[v] = seg_min[v] =  new_val;
		    } else {
		        int tm = (tl + tr) / 2;
		        if (pos <= tm)
		            update(v*2, tl, tm, pos, new_val);
		        else
		            update(v*2+1, tm+1, tr, pos, new_val);
		        seg_max[v] = max(seg_max[v*2],seg_max[v*2+1]);
		        seg_min[v] = min(seg_min[v*2],seg_max[v*2+1]);
		    }
		}
		
		int max_query(int v, int tl, int tr, int l, int r) {
		    if (l > r) 
		        return 0;
		    if (l == tl && r == tr) 
		        return seg_max[v];
		    int tm = (tl + tr) / 2;
		    return max(max_query(v*2, tl, tm, l, min(r, tm)),max_query(v*2+1, tm+1, tr, max(l, tm+1), r));
		}
		
		int min_query(int v, int tl, int tr, int l, int r) {
		    if (l > r) 
		        return 0;
		    if (l == tl && r == tr) 
		        return seg_min[v];
		    int tm = (tl + tr) / 2;
		    return min(min_query(v*2, tl, tm, l, min(r, tm)),min_query(v*2+1, tm+1, tr, max(l, tm+1), r));
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