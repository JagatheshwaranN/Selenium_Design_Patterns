package qa.bundle.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class JsonReader {

        public static List<HashMap<String, String>> getJsonData(String filePath){
            Path jsonFilePath = Paths.get(filePath);
            String jsonFileContent;
            List<HashMap<String, String>> travelData;
            try {
                jsonFileContent = Files.readString(jsonFilePath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            ObjectMapper mapper = new ObjectMapper();
            try {
                travelData = mapper.readValue(jsonFileContent, new TypeReference<List<HashMap<String, String>>>(){});
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            return travelData;
        }

}
