import java.io.IOException;

/**
 * Created by Jakob Makovac on 22/03/2017.
 */
public class Testing {
    public static void main(String[] args) throws IOException {
        Seminar1 seminar = new Seminar1();
        Seminar1.ImageHandler imageHandler = seminar.new ImageHandler();

        System.out.println(System.getProperty("user.dir"));

        imageHandler.loadBMP("test.bmp");

        System.out.println(imageHandler.width);
        System.out.println(imageHandler.height);

        for(int i = 0; i<imageHandler.width; i++){
            for(int j = 0; j<imageHandler.height; j++){
                System.out.print(imageHandler.heightMap[i][j] + " ");
            }
            System.out.println();
        }
    }
}
