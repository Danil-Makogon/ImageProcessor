import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ImageDescriptor {

    private String imageURL;
    private String actionName;

    public ImageDescriptor(String imageURL, String actionName) {
        this.imageURL = imageURL;
        this.actionName = actionName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getActionName() {
        return actionName;
    }

    private ImageDescriptor csvFileToImageDescriptor(String fileName) throws IOException {
        ImageDescriptor descriptor = new ImageDescriptor("", "");
        String row;
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        while ((row = br.readLine()) != null) {
            String[] result = row.split(",");
            descriptor.imageURL=result[0];
            descriptor.actionName=result[1];
        }
        br.close();
        return descriptor;
    }
}