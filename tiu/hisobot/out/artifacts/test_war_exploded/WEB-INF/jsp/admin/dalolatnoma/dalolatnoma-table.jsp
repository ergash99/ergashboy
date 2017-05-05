<%@ page import="uz.tiu.daily.controllers.admin.topshiriq.TopshiriqController" %>
<%@ page import="uz.tiu.daily.controllers.admin.smeta.SmetaController" %>
<%@ page import="uz.tiu.daily.controllers.admin.dalolatnoma.DalolatnomaController" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--@elvariable id="list" type="uz.tiu.daily.persistence.Dalolatnoma"--%>
<%--
  Created by IntelliJ IDEA.
  User: ERGASHBOY_JAVA
  Date: 21.04.17
  Time: 0:24
  To change this template use File | Settings | File Templates.
--%>
<div role="main" class="main">
<div class="slider-container">
    <div class="slider" id="revolutionSlider" data-plugin-revolution-slider data-plugin-options='{"startheight": 500}'>
        <ul>
            <li data-transition="fade" data-slotamount="13" data-masterspeed="300" >

                <img src="img/slides/slide-bg.jpg" data-bgfit="cover" data-bgposition="left top" data-bgrepeat="no-repeat">

                <div class="tp-caption sft stb visible-lg"
                     data-x="177"
                     data-y="180"
                     data-speed="300"
                     data-start="1000"
                     data-easing="easeOutExpo"><img src="img/slides/slide-title-border.png" alt=""></div>

                <div class="tp-caption top-label lfl stl"
                     data-x="227"
                     data-y="180"
                     data-speed="300"
                     data-start="500"
                     data-easing="easeOutExpo">DO YOU NEED A NEW</div>

                <div class="tp-caption sft stb visible-lg"
                     data-x="477"
                     data-y="180"
                     data-speed="300"
                     data-start="1000"
                     data-easing="easeOutExpo"><img src="img/slides/slide-title-border.png" alt=""></div>

                <div class="tp-caption main-label sft stb"
                     data-x="135"
                     data-y="210"
                     data-speed="300"
                     data-start="1500"
                     data-easing="easeOutExpo">WEB DESIGN?</div>

                <div class="tp-caption bottom-label sft stb"
                     data-x="185"
                     data-y="280"
                     data-speed="500"
                     data-start="2000"
                     data-easing="easeOutExpo">Check out our options and features.</div>

                <div class="tp-caption randomrotate"
                     data-x="905"
                     data-y="248"
                     data-speed="500"
                     data-start="2500"
                     data-easing="easeOutBack"><img src="img/slides/slide-concept-2-1.png" alt=""></div>

                <div class="tp-caption sfb"
                     data-x="955"
                     data-y="200"
                     data-speed="400"
                     data-start="3000"
                     data-easing="easeOutBack"><img src="img/slides/slide-concept-2-2.png" alt=""></div>

                <div class="tp-caption sfb"
                     data-x="925"
                     data-y="170"
                     data-speed="700"
                     data-start="3150"
                     data-easing="easeOutBack"><img src="img/slides/slide-concept-2-3.png" alt=""></div>

                <div class="tp-caption sfb"
                     data-x="875"
                     data-y="130"
                     data-speed="1000"
                     data-start="3250"
                     data-easing="easeOutBack"><img src="img/slides/slide-concept-2-4.png" alt=""></div>

                <div class="tp-caption sfb"
                     data-x="605"
                     data-y="80"
                     data-speed="600"
                     data-start="3450"
                     data-easing="easeOutExpo"><img src="img/slides/slide-concept-2-5.png" alt=""></div>

                <div class="tp-caption blackboard-text lfb "
                     data-x="635"
                     data-y="300"
                     data-speed="500"
                     data-start="3450"
                     data-easing="easeOutExpo" style="font-size: 37px;">Think</div>

                <div class="tp-caption blackboard-text lfb "
                     data-x="660"
                     data-y="350"
                     data-speed="500"
                     data-start="3650"
                     data-easing="easeOutExpo" style="font-size: 47px;">Outside</div>

                <div class="tp-caption blackboard-text lfb "
                     data-x="685"
                     data-y="400"
                     data-speed="500"
                     data-start="3850"
                     data-easing="easeOutExpo" style="font-size: 32px;">The box :)</div>
            </li>
            <li data-transition="fade" data-slotamount="5" data-masterspeed="1000" >

                <img src="img/slides/slide-bg.jpg" data-bgfit="cover" data-bgposition="left top" data-bgrepeat="no-repeat">

                <div class="tp-caption sft stb"
                     data-x="155"
                     data-y="100"
                     data-speed="600"
                     data-start="100"
                     data-easing="easeOutExpo"><img src="img/slides/slide-concept.png" alt=""></div>

                <div class="tp-caption blackboard-text sft stb"
                     data-x="285"
                     data-y="180"
                     data-speed="900"
                     data-start="1000"
                     data-easing="easeOutExpo" style="font-size: 30px;">easy to</div>

                <div class="tp-caption blackboard-text sft stb"
                     data-x="285"
                     data-y="220"
                     data-speed="900"
                     data-start="1200"
                     data-easing="easeOutExpo" style="font-size: 40px;">customize!</div>

                <div class="tp-caption main-label sft stb"
                     data-x="685"
                     data-y="190"
                     data-speed="300"
                     data-start="900"
                     data-easing="easeOutExpo">DESIGN IT!</div>

                <div class="tp-caption bottom-label sft stb"
                     data-x="685"
                     data-y="250"
                     data-speed="500"
                     data-start="2000"
                     data-easing="easeOutExpo">Create slides with brushes and fonts.</div>

            </li>
        </ul>
    </div>
</div>
<div class="home-intro" id="home-intro">
    <div class="container">

        <div class="row">
            <div class="col-md-8">
                <p>
                    The fastest way to grow your business with the leader in <em>Technology</em>
                    <span>Check out our options and features included.</span>
                </p>
            </div>
            <div class="col-md-4">
                <div class="get-started">
                    <a href="#" class="btn btn-lg btn-primary">Get Started Now!</a>
                    <div class="learn-more">or <a href="index.html">learn more.</a></div>
                </div>
            </div>
        </div>

    </div>
</div>

<div class="container">

    <div class="row center">
        <div class="col-md-12">
            <h1 class="short word-rotator-title">
                Porto is
                <strong class="inverted">
									<span class="word-rotate" data-plugin-options='{"delay": 2000, "animDelay": 300}'>
										<span class="word-rotate-items">
											<span>incredibly</span>
											<span>especially</span>
											<span>extremely</span>
										</span>
									</span>
                </strong>
                beautiful and fully responsive.
            </h1>
            <p class="featured lead">
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce elementum, nulla vel pellentesque consequat, ante nulla hendrerit arcu, ac tincidunt mauris lacus sed leo. vamus suscipit molestie vestibulum.
            </p>
        </div>
    </div>

</div>

<div class="home-concept">
    <div class="container">

        <div class="row center">
            <span class="sun"></span>
            <span class="cloud"></span>
            <div class="col-md-2 col-md-offset-1">
                <div class="process-image" data-appear-animation="bounceIn">
                    <img src="img/home-concept-item-1.png" alt="" />
                    <strong>Strategy</strong>
                </div>
            </div>
            <div class="col-md-2">
                <div class="process-image" data-appear-animation="bounceIn" data-appear-animation-delay="200">
                    <img src="img/home-concept-item-2.png" alt="" />
                    <strong>Planning</strong>
                </div>
            </div>
            <div class="col-md-2">
                <div class="process-image" data-appear-animation="bounceIn" data-appear-animation-delay="400">
                    <img src="img/home-concept-item-3.png" alt="" />
                    <strong>Build</strong>
                </div>
            </div>
            <div class="col-md-4 col-md-offset-1">
                <div class="project-image">
                    <div id="fcSlideshow" class="fc-slideshow">
                        <ul class="fc-slides">
                            <li><a href="portfolio-single-project.html"><img class="img-responsive" src="img/projects/project-home-1.jpg" /></a></li>
                            <li><a href="portfolio-single-project.html"><img class="img-responsive" src="img/projects/project-home-2.jpg" /></a></li>
                            <li><a href="portfolio-single-project.html"><img class="img-responsive" src="img/projects/project-home-3.jpg" /></a></li>
                        </ul>
                    </div>
                    <strong class="our-work">Our Work</strong>
                </div>
            </div>
        </div>

    </div>
</div>

<div class="container">

    <div class="row">
        <hr class="tall" />
    </div>

</div>

<div class="container">

    <div class="row">
        <div class="col-md-8">
            <h2>Our <strong>Features</strong></h2>
            <div class="row">
                <div class="col-sm-6">
                    <div class="feature-box">
                        <div class="feature-box-icon">
                            <i class="fa fa-group"></i>
                        </div>
                        <div class="feature-box-info">
                            <h4 class="shorter">Customer Support</h4>
                            <p class="tall">Lorem ipsum dolor sit amet, consectetur adip.</p>
                        </div>
                    </div>
                    <div class="feature-box">
                        <div class="feature-box-icon">
                            <i class="fa fa-file"></i>
                        </div>
                        <div class="feature-box-info">
                            <h4 class="shorter">HTML5 / CSS3 / JS</h4>
                            <p class="tall">Lorem ipsum dolor sit amet, adip.</p>
                        </div>
                    </div>
                    <div class="feature-box">
                        <div class="feature-box-icon">
                            <i class="fa fa-google-plus"></i>
                        </div>
                        <div class="feature-box-info">
                            <h4 class="shorter">500+ Google Fonts</h4>
                            <p class="tall">Lorem ipsum dolor sit amet, consectetur adip.</p>
                        </div>
                    </div>
                    <div class="feature-box">
                        <div class="feature-box-icon">
                            <i class="fa fa-adjust"></i>
                        </div>
                        <div class="feature-box-info">
                            <h4 class="shorter">Colors</h4>
                            <p class="tall">Lorem ipsum dolor sit amet, consectetur adip.</p>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="feature-box">
                        <div class="feature-box-icon">
                            <i class="fa fa-film"></i>
                        </div>
                        <div class="feature-box-info">
                            <h4 class="shorter">Sliders</h4>
                            <p class="tall">Lorem ipsum dolor sit amet, consectetur.</p>
                        </div>
                    </div>
                    <div class="feature-box">
                        <div class="feature-box-icon">
                            <i class="fa fa-user"></i>
                        </div>
                        <div class="feature-box-info">
                            <h4 class="shorter">Icons</h4>
                            <p class="tall">Lorem ipsum dolor sit amet, consectetur adip.</p>
                        </div>
                    </div>
                    <div class="feature-box">
                        <div class="feature-box-icon">
                            <i class="fa fa-bars"></i>
                        </div>
                        <div class="feature-box-info">
                            <h4 class="shorter">Buttons</h4>
                            <p class="tall">Lorem ipsum dolor sit, consectetur adip.</p>
                        </div>
                    </div>
                    <div class="feature-box">
                        <div class="feature-box-icon">
                            <i class="fa fa-desktop"></i>
                        </div>
                        <div class="feature-box-info">
                            <h4 class="shorter">Lightbox</h4>
                            <p class="tall">Lorem sit amet, consectetur adip.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <h2>and more...</h2>

            <div class="panel-group" id="accordion">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                                <i class="fa fa-usd"></i>
                                Pricing Tables
                            </a>
                        </h4>
                    </div>
                    <div id="collapseOne" class="accordion-body collapse in">
                        <div class="panel-body">
                            Donec tellus massa, tristique sit amet condim vel, facilisis quis sapien. Praesent id enim sit amet odio vulputate eleifend in in tortor.
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
                                <i class="fa fa-comment"></i>
                                Contact Forms
                            </a>
                        </h4>
                    </div>
                    <div id="collapseTwo" class="accordion-body collapse">
                        <div class="panel-body">
                            Donec tellus massa, tristique sit amet condimentum vel, facilisis quis sapien.
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
                                <i class="fa fa-laptop"></i>
                                Portfolio Pages
                            </a>
                        </h4>
                    </div>
                    <div id="collapseThree" class="accordion-body collapse">
                        <div class="panel-body">
                            Donec tellus massa, tristique sit amet condimentum vel, facilisis quis sapien.
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <hr class="tall" />

    <div class="row center">
        <div class="col-md-12">
            <h2 class="short word-rotator-title">
                We're not the only ones
                <strong>
									<span class="word-rotate" data-plugin-options='{"delay": 3500, "animDelay": 400}'>
										<span class="word-rotate-items">
											<span>excited</span>
											<span>happy</span>
										</span>
									</span>
                </strong>
                about Porto Template...
            </h2>
            <h4 class="lead tall">5,500 customers in 100 countries use Porto Template. Meet our customers.</h4>
        </div>
    </div>
    <div class="row center">
        <div class="owl-carousel" data-plugin-options='{"items": 6, "autoplay": true, "autoplayTimeout": 3000}'>
            <div>
                <img class="img-responsive" src="img/logos/logo-1.png" alt="">
            </div>
            <div>
                <img class="img-responsive" src="img/logos/logo-2.png" alt="">
            </div>
            <div>
                <img class="img-responsive" src="img/logos/logo-3.png" alt="">
            </div>
            <div>
                <img class="img-responsive" src="img/logos/logo-4.png" alt="">
            </div>
            <div>
                <img class="img-responsive" src="img/logos/logo-5.png" alt="">
            </div>
            <div>
                <img class="img-responsive" src="img/logos/logo-6.png" alt="">
            </div>
            <div>
                <img class="img-responsive" src="img/logos/logo-4.png" alt="">
            </div>
            <div>
                <img class="img-responsive" src="img/logos/logo-2.png" alt="">
            </div>
        </div>
    </div>

</div>

<div class="map-section">
    <section class="featured footer map">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <div class="recent-posts push-bottom">
                        <h2>Latest <strong>Blog</strong> Posts</h2>
                        <div class="row">
                            <div class="owl-carousel" data-plugin-options='{"items": 1}'>
                                <div>
                                    <div class="col-md-6">
                                        <article>
                                            <div class="date">
                                                <span class="day">15</span>
                                                <span class="month">Jan</span>
                                            </div>
                                            <h4><a href="blog-post.html">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</a></h4>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec hendrerit vehicula est, in consequat libero. <a href="/" class="read-more">read more <i class="fa fa-angle-right"></i></a></p>
                                        </article>
                                    </div>
                                    <div class="col-md-6">
                                        <article>
                                            <div class="date">
                                                <span class="day">15</span>
                                                <span class="month">Jan</span>
                                            </div>
                                            <h4><a href="blog-post.html">Lorem ipsum dolor</a></h4>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec hendrerit vehicula est, in consequat. <a href="/" class="read-more">read more <i class="fa fa-angle-right"></i></a></p>
                                        </article>
                                    </div>
                                </div>
                                <div>
                                    <div class="col-md-6">
                                        <article>
                                            <div class="date">
                                                <span class="day">12</span>
                                                <span class="month">Jan</span>
                                            </div>
                                            <h4><a href="blog-post.html">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</a></h4>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec hendrerit vehicula est, in consequat libero. <a href="/" class="read-more">read more <i class="fa fa-angle-right"></i></a></p>
                                        </article>
                                    </div>
                                    <div class="col-md-6">
                                        <article>
                                            <div class="date">
                                                <span class="day">11</span>
                                                <span class="month">Jan</span>
                                            </div>
                                            <h4><a href="blog-post.html">Lorem ipsum dolor</a></h4>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. <a href="/" class="read-more">read more <i class="fa fa-angle-right"></i></a></p>
                                        </article>
                                    </div>
                                </div>
                                <div>
                                    <div class="col-md-6">
                                        <article>
                                            <div class="date">
                                                <span class="day">15</span>
                                                <span class="month">Jan</span>
                                            </div>
                                            <h4><a href="blog-post.html">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</a></h4>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec hendrerit vehicula est, in consequat libero. <a href="/" class="read-more">read more <i class="fa fa-angle-right"></i></a></p>
                                        </article>
                                    </div>
                                    <div class="col-md-6">
                                        <article>
                                            <div class="date">
                                                <span class="day">15</span>
                                                <span class="month">Jan</span>
                                            </div>
                                            <h4><a href="blog-post.html">Lorem ipsum dolor</a></h4>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec hendrerit vehicula est, in consequat. <a href="/" class="read-more">read more <i class="fa fa-angle-right"></i></a></p>
                                        </article>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <h2><strong>What</strong> Client’s Say</h2>
                    <div class="row">
                        <div class="owl-carousel push-bottom" data-plugin-options='{"items": 1}'>
                            <div>
                                <div class="col-md-12">
                                    <blockquote class="testimonial">
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec hendrerit vehicula est, in consequat. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec hendrerit vehicula est, in consequat.  Donec hendrerit vehicula est, in consequat.  Donec hendrerit vehicula est, in consequat.</p>
                                    </blockquote>
                                    <div class="testimonial-arrow-down"></div>
                                    <div class="testimonial-author">
                                        <div class="img-thumbnail img-thumbnail-small">
                                            <img src="img/clients/client-1.jpg" alt="">
                                        </div>
                                        <p><strong>John Smith</strong><span>CEO & Founder - Okler</span></p>
                                    </div>
                                </div>
                            </div>
                            <div>
                                <div class="col-md-12">
                                    <blockquote class="testimonial">
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec hendrerit vehicula est, in consequat. Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                                    </blockquote>
                                    <div class="testimonial-arrow-down"></div>
                                    <div class="testimonial-author">
                                        <div class="img-thumbnail img-thumbnail-small">
                                            <img src="img/clients/client-1.jpg" alt="">
                                        </div>
                                        <p><strong>John Smith</strong><span>CEO & Founder - Okler</span></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
</div>
<script>
    $(document).ready(function () {
        url_base = '/admin/dalolatnoma';
        div_base = 'dalolatnoma-table';
        console.log(url_base);
    })
</script>
