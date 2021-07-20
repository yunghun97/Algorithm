package Basic;

public class SsafyBuling {
public static void main(String[] args) {
	char[][] box = {
			{'G','B','G','G','B','G'},
			{'G','B','G','G','B','G'},
			{'B','B','B','B','G','B'},
			{'B','G','B','B','B','B'},
			{'B','B','B','B','B','G'},
			{'G','B','B','B','B','G'}};
	int n = box.length;
	int[] x = {-1,-1,-1,0,0,1,1,1};
	int[] y = {-1,0,1,-1,1,-1,0,1};
	int result = 0;
	int temp =0;
	int count= 0;
	int bCount =0;
	for(int r = 0; r<n; r++) {
		for(int c=0; c<n; c++) {
			if(box[r][c]=='B'){
				for(int d=0; d<8; d++) {
					int nr= r + x[d];
					int nc= c + y[d];
				if(nr>=0&&nr<n&&nc>=0&&nc<n&&box[nr][nc]=='G'){
						count++;
				}
				if(nr>=0&&nr<n&&nc>=0&&nc<n&&box[nr][nc]=='B') {
						bCount++;
						count++;
					}
				}
			}
			if((bCount==count)&&count!=0) {
				for(int i=0; i<n; i++) {
					if(box[r][i]=='B'){
						++temp;
					}
					if(box[i][c]=='B')
						++temp;
				}
				if(temp>result)
					result = temp;
			}
			count=0;
			bCount=0;
			temp=0;
		}
	}
	System.out.println(result);
	}	
}