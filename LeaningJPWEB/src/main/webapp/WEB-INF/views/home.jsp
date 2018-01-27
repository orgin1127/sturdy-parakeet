<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	
	<style>
		@import "bourbon";
		@import url(https://fonts.googleapis.com/css?family=Roboto:400,300);
		
		html,
		body {
		  display: table;
		  width: 100%;
		  height: 100%;
		  background: -webkit-linear-gradient(90deg, #1CD8D2 10%, #93EDC7 90%); /* Chrome 10+, Saf5.1+ */
		  background:    -moz-linear-gradient(90deg, #1CD8D2 10%, #93EDC7 90%); /* FF3.6+ */
		  background:     -ms-linear-gradient(90deg, #1CD8D2 10%, #93EDC7 90%); /* IE10 */
		  background:      -o-linear-gradient(90deg, #1CD8D2 10%, #93EDC7 90%); /* Opera 11.10+ */
		  background:         linear-gradient(90deg, #1CD8D2 10%, #93EDC7 90%); /* W3C */
		}
		
		button:focus {
		  outline: none;
		}
		
		.main-ctr {
		  display: table-cell;
		  vertical-align: middle;
		  text-align: center;
		}
		
		.dialog-wrapper {
		  position: relative;
		  display: inline-block;
		  height: 249px;
		  width: 369px;
		  
		  p {
		    position: absolute;
		    top: 50%;
		    margin-top: -24px;
		    left: 0;
		    right: 0;
		    text-align: center;
		    line-height: 1.5;
		    font-family: "roboto";
		    padding: 0 20px;
		    box-sizing: border-box;
		    font-weight: 300;
		    opacity: 0;
		    color: #999;
		    transition: .45s all ease;
		    pointer-events: none;
		    letter-spacing: 1.5px;
		    
		    &.show {
		      opacity: 1;
		    }
		  }
		  
		  .open {
		    position: absolute;
		    top: 50%;
		    left: 50%;
		    width: 160px;
		    height: 45px;
		    margin-top: -22.5px;
		    margin-left: -80.5px;
		    border: none;
		    background: white;
		    font-size: 14px;
		    color: black;
		    cursor: pointer;
		    transition: .3s all ease;
		    letter-spacing: 1.5px;
		    
		    &.off {
		      pointer-events: none;
		      opacity: 0;
		    }
		  }
		  
		  .close {
		    position: absolute;
		    top: 25px;
		    right: 25px;
		    width: 40px;
		    height: 40px;
		    border-radius: 50%;
		    border: none;
		    background: -webkit-linear-gradient(90deg, #1CD8D2 10%, #93EDC7 90%); /* Chrome 10+, Saf5.1+ */
		    background:    -moz-linear-gradient(90deg, #1CD8D2 10%, #93EDC7 90%); /* FF3.6+ */
		    background:     -ms-linear-gradient(90deg, #1CD8D2 10%, #93EDC7 90%); /* IE10 */
		    background:      -o-linear-gradient(90deg, #1CD8D2 10%, #93EDC7 90%); /* Opera 11.10+ */
		    background:         linear-gradient(90deg, #1CD8D2 10%, #93EDC7 90%); /* W3C */
		    color: white;
		    font-size: 16px;
		    /* box-shadow: 0 1px 6px rgba(0,0,0,0.2); */
		    cursor: pointer;
		  }
		  
		  svg {
		    
		    #step-0,
		    #step-1,
		    #step-2,
		    #step-3,
		    #step-4 {
		      visibility: hidden;
		    }
		  }
		}
	</style>
	<script>
	var box = $("#box"),
    open = $(".open"),
    close = $(".close"),
    text = $("p"),
    step0 = "#step-0",
    step1 = "#step-1",
    step2 = "#step-2",
    step3 = "#step-3",
    step4 = "#step-4";

TweenMax.set(close, {
  scale: 0,
  transformOrigin: "center center"
});

var tl = new TimelineMax({
});

open.on("click", function(){

  $(this).addClass("off");

  tl
  .to(box, .2, {
    morphSVG:{
      shape: step1
    },
    delay: .3,
    ease: Power4.easeOut
  })
  .to(box, .2, {
    morphSVG:{
      shape: step2
    },
    ease: Power4.easeOut
  })
  .to(box, .2, {
    morphSVG:{
      shape: step3
    },
    ease: Power4.easeOut
  })
  .to(box, .2, {
    morphSVG:{
      shape: step4
    },
    ease: Power4.easeOut
  })
  .set(text, {className:"+=show"})
  
  .to(close, .3, {
    scale: 1,
    delay: .3,
    ease: Bounce.easeOut
  })

});

close.on("click", function(){

  tl
  .to(close, .3, {
    scale: 0,
    ease: Power4.easeOut
  })
  .set(text, {className:"-=show"})
  .to(box, .2, {
    morphSVG:{
      shape: step3
    },
    delay: .3,
    ease: Power4.easeOut
  })
  .to(box, .2, {
    morphSVG:{
      shape: step2
    },
    ease: Power4.easeOut
  })
  .to(box, .2, {
    morphSVG:{
      shape: step1
    },
    ease: Power4.easeOut
  })
  .to(box, .2, {
    morphSVG:{
      shape: step0
    },
    ease: Power4.easeOut
  })

  .set(open, {className:"-=off"});

})

// copy
balapaCop("Origami Dialog Effect", "rgba(255,255,255,.9)");
	</script>
</head>
<body>
<h1>Hello world!</h1>

<div class="main-ctr">
  <div class="dialog-wrapper">
    <button class="open">Open Dialog</button>
    <button class="close">X</button>
    <p>Hello, it's a me!<br>Mariooooo!</p>
    <svg width="369" height="249" viewBox="0 0 369 249" xmlns="http://www.w3.org/2000/svg">
      <g id="Page-1" fill="none" fill-rule="evenodd">
        <path d="M264.483 102v45h-160v-45h160z" id="step-0" fill="#FFF"/>
        <path d="M264.483 102v45h-160L-.004-.025 264.483 102z" id="step-1" fill-opacity=".1" fill="#D8D8D8"/>
        <path d="M369.02-.025L264.484 147h-160L-.004-.025H369.02z" id="step-2" fill-opacity=".2" fill="#D8D8D8"/>
        <path d="M369.01-.025L264.482 147-.004 249V-.024H369.01z" id="step-3" fill-opacity=".3" fill="#D8D8D8"/>
        <path d="M.042-.004h368.97v249H-.003l.045-249z" id="step-4" fill-opacity=".4" fill="#D8D8D8"/>
        <path d="M264.483 102v45h-160v-45h160z" id="box" fill="#FFF"/>
      </g>
    </svg>
  </div>
</div>
</body>
</html>
