<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/scroll.css">
<title>Entrance</title>
</head>
<body class="entrance-body">
	<header>
		<%@ include file="header.jsp" %>
	</header>
	<!--  スクロールアニメーション開始 -->
	 <!-- section01 -->
    <section class="sec-01">
      <div class="container">
        <h2 class="main-title">Wellcome to Additive.</h2>
        <hr>
        <div class="content">
          <div class="image">
            <img src="./image/food.png" alt="野菜"  />
          </div>
          <div class="text-box">
            <h3>おおきに</h3>
            <p>
              お前ら添加物って何か体に悪そうやなーで終わってないか？
              添加物にも種類があるんや、もっと言うとその種類によって体にどう影響してくるかも全く違うんや
              そこんとこを、お前らみたいなサルでもすぐ見れるようにしたのがこのサイトや
              <br>わかる？
            </p>
          </div>
        </div>
        <div class="media-icons">
          <a href="#" class="icon"><i class="fab fa-facebook"></i></a>
          <a href="#" class="icon"><i class="fab fa-instagram"></i></a>
          <a href="#" class="icon"><i class="fab fa-twitter"></i></a>
          <a href="#" class="icon"><i class="fab fa-youtube"></i></a>
        </div>
      </div>
    </section>

    <!-- section02 -->
    <section class="sec-02">
      <div class="container">
        <h3 class="section-title">Do you have your health ?</h3>
        <hr>
        <div class="content">
          <div class="image">
          	<img src="./image/top-page.jpg" alt="" /> 
				<a class="sign_up" href="sign_up.jsp">新規登録</a>
				<a class="log_in" href="log_in.jsp">ログイン</a>
          </div>
          <div class="info">
            <h4 class="info-title">Additive introduce</h4>
            <p class="info-title-p">
              現在我が国日本で販売されている食品の多くは、添加物が含まれています。<br>
              このこと自体は、近頃世間に浸透してきているのではないかと思います。<br>
              また、食品に含まれている添加物は商品の原材料名として明記しなければならないと法律で定められています。
              ですので、皆さんが購入した食品に含まれている添加物は商品の原材料名欄を見ればすぐに確認することができます。
              しかし、その添加物が自分の体にどういう影響を及ぼすのかは皆さんは把握できていますか？<br>
              添加物がどういう風な影響をおよおぼすものなのかをすぐに確認できるのが当サイトです！<br>
            </p>
          </div>
        </div>
      </div>
    </section>

    <!-- section03 -->
    <section class="sec-03">
      <div class="container">
        <h3 class="section-title">Creaters's SNS</h3>
        <hr>
        <div class="content">
          <div class="media-info">
            <li>
              <a href="#"><i class="fab facebook"></i> Facebook</a>
            </li>
            <li>
              <a href="#"><i class="fab fa-instagram"></i> Instagram</a>
            </li>
            <li>
              <a href="#"><i class="fab fa-twitter"></i> Twitter</a>
            </li>
            <li>
              <a href="#"><i class="fab fa-youtube"></i> Youtube</a>
            </li>
            <li>
              <a href="#"><i class="fab fa-linkedin"></i> Linkedin</a>
            </li>
          </div>
          <div class="image">
            <img src="./images/img3.jpg" alt="" />
          </div>
        </div>
      </div>
    </section>

    <script src="https://unpkg.com/scrollreveal"></script>
    <script>
      //共通のオプション設定
      ScrollReveal({
        reset: true,
        distance: "60px",
        duration: 2000, //2sかけてアニメーション
        delay: 200 /* 0.2s後に発動 */,
      });

      ScrollReveal().reveal(".main-title, .section-title", {
        delay: 200,
        origin: "left",
      });
      ScrollReveal().reveal(".sec-01 .image, .info", {
        delay: 600,
        origin: "bottom",
      });
      ScrollReveal().reveal(".text-box", {
        delay: 700,
        origin: "right",
      });
      ScrollReveal().reveal(".media-icons i", {
        delay: 500,
        origin: "bottom",
        interval: 200,
      });
      ScrollReveal().reveal(".sec-02 .image, .sec-03 .image", {
        delay: 500,
        origin: "top",
      });
      ScrollReveal().reveal(".media-info li", {
        delay: 500,
        origin: "left",
        interval: 200,
      });
    </script>
	
	<!--  スクロールアニメーション終了 -->
</body>
<footer>
        <div class="wrapper">
            <p>
                <small>
                    &copy; 2024 ハッカソン Additive
                </small>
            </p>
        </div>
    </footer>
</html>