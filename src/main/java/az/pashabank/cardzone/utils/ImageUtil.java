package az.pashabank.cardzone.utils;

import az.pashabank.cardzone.dao.entity.Image;
import az.pashabank.cardzone.service.CharacterService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Base64Utils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

public class ImageUtil {

    private final static String dir = "C:\\Users\\mikac\\IdeaProjects\\WorldofDisney\\images\\";
    private static final Log log = LogFactory.getLog(CharacterService.class);
    public static Image saveImageToLocalSystem(MultipartFile imageFile) throws IOException {
        if (imageFile == null || imageFile.isEmpty()) {
            throw new IllegalArgumentException("No image provided in the request");
        }
        String fileName = imageFile.getOriginalFilename();
        String imageName = UUID.randomUUID() + fileName.substring(fileName.lastIndexOf("."));
        File path = new File(dir + imageName);
        log.info("Image path => " + path.getPath());
        try (FileOutputStream output = new FileOutputStream(path)){
            output.write(imageFile.getBytes());
            Image image = new Image();
            image.setPath(path.getPath());
            output.close();
            return image;
        }catch (IOException ioe){
            throw new IOException("Could not save image file: " + fileName, ioe);
        }
    }

    public static Image saveBase64ImageToLocalSystem(String base64ImageData,Long movie_id) throws IOException {
        if (base64ImageData == null || base64ImageData.isEmpty()) {
            throw new IllegalArgumentException("No image data provided in the request");
        }
        byte[] imageBytes = Base64Utils.decodeFromString(base64ImageData);
        String imageName = "movieId" + movie_id.toString() + ".jpg";
        File path = new File(dir + imageName);
        log.info("Image path => " + path.getPath());
        try (FileOutputStream output = new FileOutputStream(path)){
            output.write(imageBytes);
            Image image = new Image();
            image.setPath(path.getPath());
            output.close();
            return image;
        }catch (IOException ioe){
            throw new IOException("Could not save image file: " + imageName, ioe);
        }
    }
}
