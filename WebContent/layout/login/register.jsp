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
    <title>Register</title>
  </head>
  <body>
    <section class="form-02-main">
      <div class="container">
        <form action="register" method="post">
            <div class="row">
                <div class="col-md-12">
                  <div class="_lk_de">
                    <div class="form-03-main">
                      <div class="logo">
                        <img src="./images/login/logo.png">
                      </div>
                      <h1 class="text-center">ĐĂNG KÝ</h1>
                      <jsp:include page="/layout/message/inform.jsp"></jsp:include>
                      <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="fullname" class="p-2"  >Họ và Tên</label>
                                <input type="text" name="fullname" class="form-control" placeholder="Nhập họ và tên" required="" aria-required="true">
                            </div>
                              
                            <div class="form-group">
                                <label for="birthday" class="p-2">Ngày sinh </label>
                                <input type="date" value="2000-12-23" name="birthday" class="form-control" required="" aria-required="true">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="username" class="p-2"  >Tài khoản</label>
                                <input type="text" name="username" class="form-control" placeholder="Nhập tài khoản" required="" aria-required="true">
                            </div>
                              
                            <div class="form-group">
                                <label for="passW" class="p-2">Mật khẩu</label>
                                <input type="password" name="passW" class="form-control"  placeholder="Nhập mật khẩu" required="" aria-required="true">
                            </div>
                        </div>
                      </div>
                     
                      <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="email" class="p-2"  >Email</label>
                                    <input type="email" name="email" class="form-control" placeholder="Nhập email" required="" aria-required="true">
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="address" class="p-2"  >Địa chỉ</label>
                                    <input type="text" name="locaAddress" class="form-control" placeholder="Nhập địa chỉ" required="" aria-required="true">
                                </div>
                            </div>
                      </div>
                      <div class="row">
                        <div class="col-md-6">
                            <label for="gender" class="p-2">Giới tính: </label>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="gender" id="gender1" value="1" checked>
                                <label class="form-check-label" for="gender1">Nam</label>
                            </div>

                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="gender" id="gender2" value="0">
                                <label class="form-check-label" for="gender2">Nữ</label>
                            </div>
                        </div>
                        <div class="col-md-6 text-end">
                            <a class="_linka" href="login">Đăng nhập</a>
                        </div>
                      </div>
                      <div class="form-group text-center">
                        <div class="_btn_04">
                          <button type="submit" class="btn" style="font-size:15px;color:#fff; width: 100%">Đăng ký</button> 
                        </div>
                      </div>
      
                      <div class="form-group nm_lk"><p>Or Login With</p></div>
      
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