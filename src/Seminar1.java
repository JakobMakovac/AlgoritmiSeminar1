import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;
import javax.imageio.ImageIO;

public class Seminar1{	
    public Seminar1(){}

    // Morebitne pomozne funkcije in razredi.
	
    public LinkedList<Pixel> solve(int[][] heightMap, int sx, int sy, int ex, int ey){
    	Pixel startCoor = new Pixel(sx, sy);
    	Pixel endCoor = new Pixel(ex, ey);
    	//TODO: vas algoritem
    	return null;
    }
   
    public static String studentId(){
    	return "63160403";
    }
    
    //Razred za nalaganje in shranjevanje slik z in iz diska
    class ImageHandler {

    	int[][] imageArray = null;
    	int[][] heightMap = null;
    	int width = 0;
    	int height = 0;
    	
    	//Nalozi sliko z diska iz .bmp oblike
    	public void loadBMP(String filename) throws IOException{
    		BufferedImage image = ImageIO.read(new File(filename));
    		width = image.getWidth();
    		height = image.getHeight();
    		imageArray = new int[width][height];
    		heightMap = new int[width][height];
    		for(int x = 0; x < width; x++){
    			for(int y = 0; y < height; y++){
    				int color = image.getRGB(x, y);
    				//imageArray[y][x] = color;
    				Color c = new Color(color);
    				heightMap[x][y] = (c.getRed() + c.getBlue() + c.getGreen())/3;
    				imageArray[x][y] = heightMap[x][y]+heightMap[x][y]*256+heightMap[x][y]*256*256;
    			}
    		}
    	}
    	
    	//Shrani sliko na disk v .bmp obliki
    	public void saveBMP(String filename) throws IOException{
    		File outputfile = new File(filename);
    		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    		int[] image1DArray = new int[width*height];
    		for(int y = 0; y < height; y++){
    			for(int x = 0; x < width; x++){
    				image1DArray[y*width + x] = imageArray[x][y];
    			}
    		}
    		image.setRGB(0,0,width,height, image1DArray, 0, width);
    		ImageIO.write(image, "bmp", outputfile);
    	}
    	
    	//Na trenutno nalozeno sliko doda pot z rdeco crto
    	public void drawPath(LinkedList<Pixel> path){
    		ListIterator<Pixel> it = path.listIterator();
    		while(it.hasNext()){
    			Pixel p = it.next();
    			imageArray[p.x][p.y] = Color.RED.getRGB();
    		}
    	}
    	
   }
    
    class Pixel {
    	public int x = 0;
    	public int y = 0;
    	Pixel(int x1, int y1){
    		x = x1;
    		y = y1;
    	}
    }

}



