package pl.javastart.urls;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
class PictureRepository {
    private final Map<String, Picture> pictures = new HashMap<>();

    PictureRepository() {
        Picture dogPicture = new Picture("dog", "Pies w okularach", "dog-glasses.jpg");
        Picture catPicture = new Picture("cat", "Gruby, rudy kot", "fat-cat.jpg");
        Picture mousePicture = new Picture("mouse", "Mysz z orzechami", "mouse.jpg");
        pictures.put(dogPicture.getId(), dogPicture);
        pictures.put(catPicture.getId(), catPicture);
        pictures.put(mousePicture.getId(), mousePicture);
    }

    Picture findImageById(String id) {
        return pictures.get(id);
    }

    Collection<Picture> findAll() {
        return pictures.values();
    }
}
