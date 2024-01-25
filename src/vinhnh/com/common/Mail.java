package vinhnh.com.common;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import vinhnh.com.dao.InvoiceDao;
import vinhnh.com.dao.ProductDao;
import vinhnh.com.dao.UserDao;
import vinhnh.com.model.Invoice;
import vinhnh.com.model.Product;
import vinhnh.com.model.User;

public class Mail {
	public void JavaMailForgotPass(String mail) {
	 	//mail và mật khẩu là app password
        final String username = "vinhnh.2312@gmail.com";
        final String password = "bnmmahhirqmoliay";

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
        	User user = new User();
        	UserDao dao = new UserDao();
        	
        	user = dao.findByEmail(mail);
            Message message = new MimeMessage(session);
            //mail cá nhân
            message.setFrom(new InternetAddress("vinhnh.2312@gmail.com"));
            //Gửi đến ai
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(mail)
            );
            //tiêu đề mail
            message.setSubject("Forgot Password " + user.getFullname()+" ");
            //nội dung mail
            message.setText("Dear " + user.getFullname()+" "
                    + "\n\n Mật khẩu của bạn là: " + user.getPassW()
                    +"\n\n Vui lòng không cung cấp mật khẩu với bất kì ai!" 
                    +"\n\n Trân trọng!");
            

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
	
	public void InvoicesMail(String userMail, int idProduct, int idInvoices) {
	 	//mail và mật khẩu là app password
        final String username = "vinhnh.2312@gmail.com";
        final String password = "bnmmahhirqmoliay";

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
        	User user = new User();
        	UserDao daoUser = new UserDao();
        	
        	user = daoUser.findByUsername(userMail);
        	
        	ProductDao daoProduct = new ProductDao(); 
        	Product product = daoProduct.findById(idProduct);
        	
        	InvoiceDao daoInvoiceDao = new InvoiceDao();
        	Invoice invoice = daoInvoiceDao.findById(idInvoices);
        	
            Message message = new MimeMessage(session);
            //mail cá nhân
            message.setFrom(new InternetAddress("vinhnh.2312@gmail.com"));
            //Gửi đến ai
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(user.getEmail().trim())
            );
            //tiêu đề mail
            message.setSubject("Đơn hàng của " + user.getFullname()+" | Mã đơn hàng: " + invoice.getId());
            //nội dung mail
            message.setText("Chào bạn, " + user.getFullname() + ","
                    + "\n\n Xin chân thành cảm ơn bạn đã đặt hàng tại cửa hàng chúng tôi. Dưới đây là thông tin chi tiết về đơn hàng của bạn:"
                    + "\n\n - Mã hóa đơn: " + invoice.getId() + "."
                    + "\n\n - Mã sản phẩm: " + product.getId() + "."
                    + "\n\n - Tên sản phẩm: " + product.getNameProduct()
                    + "\n\n - Số lượng: " + invoice.getQuantity() + "."
                    + "\n\n - Số điện thoại liên hệ: " + invoice.getPhone() + "."
                    + "\n\n - Địa chỉ giao hàng: " + invoice.getPlaceDelivery() + "."
                    + "\n\n - Ngày mua: " + invoice.getCreateDate() + "."
                    + "\n\n - Tổng tiền thanh toán: " + invoice.getTotalMoney() + "."
                    + "\n\n - Tình trạng đơn hàng: " + "Đang chờ duyệt" + "."
                    + "\n\n Vui lòng kiểm tra thông tin trên và liên hệ chúng tôi nếu có bất kỳ sai sót nào. Chúng tôi sẽ chuyển đơn hàng của bạn trong thời gian sớm nhất."
                    + "\n\n Để liên hệ với chúng tôi, bạn có thể gọi theo số điện thoại: 0399989849 hoặc gửi email đến địa chỉ: vinhnh.2312@gmail.com."
                    + "\n\n Chúng tôi rất mong được phục vụ bạn và chúc bạn một ngày an lành."
                    + "\n\n Trân trọng!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
