<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
   
   .stage{
      -webkit-perspective: 400;
      -ms-perspective: 400;
      -o-perspective: 400;
      -moz-perspective: 400;
      perspective: 400;
   }

   
   .cube {
      height: 100px;
      width: 100px;
      position: relative;
      margin: 0 auto;
      
      transform-style: preserve-3d;
      -webkit-transform-style: preserve-3d;
      -ms-transform-style: preserve-3d;
      -o-transform-style: preserve-3d;
      
      transform: rotateY(-30deg) rotateX(15deg);
      -webkit-transform: rotateY(-30deg) rotateX(15deg);
      -ms-transform: rotateY(-30deg) rotateX(15deg);
      -o-transform: rotateY(-30deg) rotateX(15deg);
      z-index: 1;
   }

   .second {
      top: -100px;
      
      transform: rotateY(-30deg) rotateX(15deg) translateZ(-400px);
      -webkit-transform: rotateY(-30deg) rotateX(15deg) translateZ(-400px);
      -ms-transform: rotateY(-30deg) rotateX(15deg) translateZ(-400px);
      -o-transform: rotateY(-30deg) rotateX(15deg) translateZ(-400px);
      z-index: 0;
   }

   .cube div {
      height: 100px;
      width: 100px;
      position: absolute;
      color: #FFF;
      text-align: center;
      line-height: 100px;
   }

   .top {
      background: rgba(0, 0, 0, 0.7);
      top: -50px;
      left: 0px;
      transform: rotateX(90deg);
      -webkit-transform: rotateX(90deg);
      -ms-transform: rotateX(90deg);
      -o-transform: rotateX(90deg);
      -moz-transform: rotateX(90deg);
   }
   
   .bottom {
      background: rgba(0, 0, 0, 0.7);
      top: 50px;
      left: 0px;
      transform: rotateX(-90deg);
      -webkit-transform: rotateX(-90deg);
      -ms-transform: rotateX(-90deg);
      -o-transform: rotateX(-90deg);
      -moz-transform: rotateX(-90deg);
   }
   
   .left {
      background: rgba(0, 160, 233, 0.7);
      top: 0px;
      left: -50px;
      transform: rotateY(90deg);
      -webkit-transform: rotateY(90deg);
      -ms-transform: rotateY(90deg);
      -o-transform: rotateY(90deg);
      -moz-transform: rotateY(90deg);
   }
   
   .right {
      background: rgba(0, 160, 233, 0.7);
      top: 0px;
      left: 50px;
      transform: rotateY(-90deg);
      -webkit-transform: rotateY(-90deg);
      -ms-transform: rotateY(-90deg);
      -o-transform: rotateY(-90deg);
      -moz-transform: rotateY(-90deg);
   }
   
   .front {
      background: rgba(215, 0, 81, 0.7);
      top: 0px;
      left: 0px;
      transform: translateZ(50px);
      -webkit-transform: translateZ(50px);
      -ms-transform: translateZ(50px);
      -o-transform: translateZ(50px);
      -moz-transform: translateZ(50px);
   }
   
   .back {
      background: rgba(215, 0, 81, 0.7);
      top: 0px;
      left: 0px;
      transform: translateZ(-50px);
      -webkit-transform: translateZ(-50px);
      -ms-transform: translateZ(-50px);
      -o-transform: translateZ(-50px);
      -moz-transform: translateZ(-50px);
   }
   
</style>
</head>
<body>

   <div class="stage">
   	  <br/>
   	  <br/>
   	  <br/>
   	  <br/>
   	  <br/>
   	  
      <div class="cube">
      <div class="top">TOP</div>
      <div class="bottom">BOTTOM</div>
      <div class="right">RIGHT</div>
      <div class="left">LEFT</div>
      <div class="back">BACK</div>
      <div class="front">FRONT</div>
   </div>
   
   <div class="cube second">
      <div class="top">TOP</div>
      <div class="bottom">BOTTOM</div>
      <div class="right">RIGHT</div>
      <div class="left">LEFT</div>
      <div class="back">BACK</div>
      <div class="front">FRONT</div>
      </div>
   </div>



</body>
</html>