import java.io.DataInputStream; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner; 
import java.util.StringTokenizer; 
import java.io.BufferedReader; 
import java.util.*;

class BookSop{
	public static Reader fs = new Reader();
	
	static PrintWriter out = new PrintWriter(System.out);
	
	static void solve() throws IOException{
		StringBuffer output = new StringBuffer();
		int n = fs.nextInt(),x = fs.nextInt();
		int cost [] = new int[n];
		int pages [] = new int[n];
		int dp [][] = new int [n+1][x+1];
		for(int i = 0; i<n; i++) cost[i] = fs.nextInt();
		for(int i = 1; i<=n; i++) {
			pages[i-1] = fs.nextInt();
			for(int j = 1; j<=x; j++) {
				if(j >= cost[i-1])dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cost[i-1]] + pages[i-1]);
				else dp[i][j] = dp[i-1][j];
			}
		}
		out.println(dp[n][x]);
	}
	
	public static void main(String[] args) throws IOException{
		int t = 1;
		//t = fs.nextInt();
		for(int cs = 1; cs <= t; cs++) {
			solve();
		}
		out.close();
	}
	
	static class Reader 
    { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 
  
        public Reader() 
        { 
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public Reader(String file_name) throws IOException 
        { 
            din = new DataInputStream(new FileInputStream(file_name)); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public String readLine() throws IOException 
        { 
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) 
            { 
                if (c == '\n') 
                    break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
        } 
  
        public int nextInt() throws IOException 
        { 
            int ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do
            { 
                ret = ret * 10 + c - '0'; 
            }  while ((c = read()) >= '0' && c <= '9'); 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public long nextLong() throws IOException 
        { 
            long ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public double nextDouble() throws IOException 
        { 
            double ret = 0, div = 1; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
  
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
  
            if (c == '.') 
            { 
                while ((c = read()) >= '0' && c <= '9') 
                { 
                    ret += (c - '0') / (div *= 10); 
                } 
            } 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        private void fillBuffer() throws IOException 
        { 
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
            if (bytesRead == -1) 
                buffer[0] = -1; 
        } 
  
        private byte read() throws IOException 
        { 
            if (bufferPointer == bytesRead) 
                fillBuffer(); 
            return buffer[bufferPointer++]; 
        } 
  
        public void close() throws IOException 
        { 
            if (din == null) 
                return; 
            din.close(); 
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
	
	static int min(int a []) {
		int x = 1_000_000_00_9;
		for(int i = 0; i<a.length; i++)x = min(x,a[i]);
		return x;
	}
	
	static int max(int a []) {
		int x = -1_000_000_00_9;
		for(int i = 0; i<a.length; i++)x = max(x,a[i]);
		return x;
	}
	
	static long min(long a []) {
		long x = (long)3e18;
		for(int i = 0; i<a.length; i++)x = min(x,a[i]);
		return x;
	}
	
	static long max(long a []) {
		long x = -(long)3e18;
		for(int i = 0; i<a.length; i++)x = max(x,a[i]);
		return x;
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