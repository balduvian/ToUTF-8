package skeledong;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Dong {
	
	char[] space = {9617,9623,9622,9603,9629,9616,9630,9631,9624,9626,9613,9625,9600,9628,9627,9608};
	boolean[][] draw;
	
	public boolean[][] fromimg(String path){
		BufferedImage b = null;
		try {
			b = ImageIO.read(new File(path));
		} catch (IOException ex){}
		int h = b.getHeight();
		int w = b.getWidth();
		boolean[][] ret = new boolean[h][w];
		for(int y=0;y<h;y++){
			for(int x=0;x<w;x++){
				if(b.getRGB(x, y)==-16777216){
					ret[y][x] = true;
				}
			}
		}
		return ret;
	}
	
	public static void main(String[] args) {
		new Dong();
	}
	
	public Dong(){
		draw = fromimg("C:\\Users\\ecoughlin7190\\Desktop\\abc.png");
		int h = draw.length/2;
		int w = draw[0].length/2;
		char[][] encode = new char[h][w];
		for(int y=0;y<h;y++){
			for(int x=0;x<w;x++){
				int plc = 0;
				for(int v=0;v<2;v++){
					for(int u=0;u<2;u++){
						if(draw[y*2+v][x*2+u]){
							plc += Math.pow(2, v+u);
						}
					}
				}
				encode[y][x] = space[plc];
			}
		}
		for(int y=0;y<h;y++){
			for(int x=0;x<w;x++){
				System.out.print(encode[y][x]);
			}
			System.out.println();
		}
	}
}
