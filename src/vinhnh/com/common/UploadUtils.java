package vinhnh.com.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;


public class UploadUtils {
	public static String FileUpload(HttpServletRequest request, String location, String ParameterName ) throws IOException, ServletException {
		String url = location;
		Path uploadPath = Paths.get(url);
		
		if(!Files.exists(Paths.get(url))) {
			Files.createDirectory(uploadPath);
		}
		
		//Xử lý tải image lên
		Part imagePart = request.getPart(ParameterName);
		
		// part.getSubmittedFileName() ấy tên của tệp tin mà người dùng đã tải lên thông qua form
		// Path.of(part.getSubmittedFileName()) Tạo một đối tượng Path từ tên tệp tin được trả về ở bước trước. 
		//Đối tượng Path được sử dụng để thực hiện các thao tác liên quan đến đường dẫn trên hệ thống tệp tin.
		//getFileName(): Lấy ra phần tên của đối tượng Path.
		//toString(): Chuyển đối tượng tên tệp tin thành một chuỗi.
		 // Kiểm tra null cho đối tượng Part
        if (imagePart != null) {
            // Sử dụng thư viện Apache Commons IO để có được tên file an toàn
            String imageFilename =  Path.of(imagePart.getSubmittedFileName()).getFileName().toString();
            // Ghi file vào thư mục lưu trữ
            imagePart.write(Paths.get(uploadPath.toString(), imageFilename).toString());
        }
        System.out.println(imagePart.getSubmittedFileName());
		return imagePart.getSubmittedFileName();
	}
}
