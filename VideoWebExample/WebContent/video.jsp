<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script type="text/javascript">

	$(document).keydown(function(e) {
		var keyCode = "";
		
		if(e.which) {
			keyCode = e.which;
		}
		else {
			keyCode = e.keyCode;
		}
		//alert(keyCode);
		
		if(keyCode > 36 && keyCode < 41) {
			$(window).scrollTop(0);
		}
		
		
		//왼쪽 화살표
		if(keyCode == 37) {
			$("#smi").css("left", "-=10px");
		}//아래쪽 화살표
		if(keyCode==38) {
			$("#smi").css("top", "-=10px");
		}//오른쪽 화살표
		if(keyCode==39) {
			$("#smi").css("left", "+=10px");
		}//위쪽 화살표
		if(keyCode==40) {
			$("#smi").css("top", "+=10px");
		}
		
	});

	$(document).ready(function() {
		
		$("#smiBackground").css("opacity", 0.5);
		
		
	});
	
	var video	=	undefined;
	var duration	=	undefined;
	var currentTime	=	undefined;
	var interval	=	undefined;
	var recommendVideo	=	undefined;
	
	function play() {
		
		if(video == undefined) {
			video = document.getElementById("video");
		}
		
		if(duration == undefined) {
			duration = document.getElementById("duration");
		}
		if(currentTime == undefined) {
			currentTime = document.getElementById("currentTime");
		}
		if(recommendVideo == undefined) {
			recommendVideo = document.getElementById("recommendVideo");
		}
		
		video.play();
		//video.currentTime = 58;
		
		duration.innerText = video.duration;
		
		var textSmi = "";
		var startTime = 0;
		var endTime = 0;
		interval= setInterval(function() {
			currentTime.innerText = video.currentTime;
			
			if(parseFloat(duration.innerText) <= parseFloat(currentTime.innerText)) {
				
				recommendVideo.style.display = "block";
				clearInterval(interval);
			}	
			else {
				$(".textSmi").each(function(index, smi) {
					startTime = parseFloat($(smi).attr("data-start") );
					endTime = parseFloat($(smi).attr("data-end") );
					
					if(video.currentTime >= startTime 
							&& video.currentTime <= endTime ) {
						textSmi = $(smi).val();
					}
				});
				if(textSmi != "") {
					$("#smiBackground").text(textSmi);
					$("#smiBackground").show();
				}
				else {
					$("#smiBackground").hide();
				}
				textSmi = "";
			}
		}, 100);
		
		//$("#smiBackground").text($(".textSmi").val());
			
	}
	
	function stop() {
		
		if(video == undefined) {
			video = document.getElementById("video");
		}
		
		video.pause();
		clearInterval(interval);
	}
	
	
</script>

<body>
	<div style="height:350px; padding:0px, margin:0px">
		<video id="video" width="500" height="350" controls>
			<source src="http://vjs.zencdn.net/v/oceans.mp4"></source>
		</video>
		<div id="recommendVideo" style="position: relative; 
										top: -354px; 
										color: white;
										background-color: blue;
										width:500px;
										height:350px;
										padding: 0px;
										margin: 0px;
										display:none;">
				추천영상!
		</div>
	
		<div id="smi" style="position: relative; 
										top: -354px;
										left: 0px; 
										color: #FFF;
										width:500px;
										height:350px;
										padding: 0px;
										margin: 0px;
										display:block;">
			<div style="height:250px">&nbsp;</div>
			
			<p style="text-align:center;">
				<span id="smiBackground" style="background-color: #000;
							padding:5px;">
					안녕하세요
					<img src="http://famouslogos.net/wp-content/uploads/2014/02/2013-Hd-Logos.png"
				 width="100" height="50"/>
				</span>
			</p>
		</div>
	</div>
	<br/>
	<input type="button" value="play" onclick="play()"/>
	<input type="button" value="pause" onclick="stop()"/>
	
	<br/>
	
	총 재생 시간		: <span id="duration"></span><br/>
	현재 재생 시간		: <span id="currentTime"></span><br/>
	<br/>
	<input type="text" class="textSmi" value="까악!~" data-start="1.6" data-end="2.0"/>
	<input type="text" class="textSmi" value="두번째에요~" data-start="10" data-end="15"/>
</body>
</html>