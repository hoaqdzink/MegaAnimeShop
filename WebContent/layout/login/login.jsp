<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.css" integrity="sha512-XJ3ntWHl40opEiE+6dGhfK9NAKOCELrpjiBRQKtu6uJf9Pli8XY+Hikp7rlFzY4ElLSFtzjx9GGgHql7PLSeog==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="./css/login/style.css" rel="stylesheet">
	<base href="/WebShopMegaAnime/">
    <title>Login</title>
  </head>
  <body>
    <section class="form-02-main">
      <div class="container">
        <form action="login" method="post">
            <div class="row">
                <div class="col-md-12">
                  <div class="_lk_de">
                    <div class="form-03-main-login">
                      <div class="logo">
                      	<a href="home"><img src="./images/login/logo.png"></a>
                        <br>
                      </div>
                      
                      <h1 class="text-center">ĐĂNG NHẬP</h1>
						<jsp:include page="/layout/message/inform.jsp"></jsp:include>
                      <div class="form-group">
                        <input type="text" name="username" class="form-control " type="text" placeholder="Enter Username" required="" aria-required="true">
                      </div>
      
                      <div class="form-group">
                        <input type="password" name="password" class="form-control " type="text" placeholder="Enter Password" required="" aria-required="true">
                      </div>
      
                      <div class="checkbox form-group">
                        <div class="form-check">
                          <input class="form-check-input" type="checkbox" name="remember">
                          <label class="form-check-label" for="">
                            Nhớ mật khẩu
                          </label>
                        </div>
                        <a class="_linka" href="forgotPassword">Quên mật khẩu</a>
                      </div>
                      <div class="text-center">
                          <a class="_linka" href="register">Đăng ký</a>
                      </div>
                      <div class="form-group text-center">
                        <div class="_btn_04">
                          <button type="submit" class="btn" style="font-size:15px;color:#fff; width: 100%">Đăng nhập</button> 
                        </div>
                      </div>
      
                      <div class="form-group nm_lk"><p>Đăng nhập bằng</p></div>
      
                      <div class="form-group pt-0">
                        <div class="_social_04">
                          <ol>
                            <li><i class="fa fa-facebook"></i></li>
                            <li><i class="fa fa-twitter"></i></li>
                            <li><i class="fa fa-google-plus"></i></li>
                            <li><i class="fa fa-instagram"></i></li>
                            <li><i class="fa fa-linkedin"></i></li>
                          </ol>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
        </form>
      </div>
    </section>
  </body>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</html>