<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<title>SCORE BATHAVO</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<div class="bg-login">
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/welcome" class="navbar-brand">Score Bhathavo</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/login">Login</a></li>
					<li><a href="/register">New Registration</a></li>
					<li><a href="/admin">Admin</a></li>
				</ul>
			</div>
			</a>
		</div>
	</div>
	<!--  <div class="container" id="homediv">
		<div class="jumbotron text-center">
			<h1>Welcome to SCORE BATHAVO</h1>
			<h3>Live score then and there...</h3>
		</div>
	</div> -->

	<section class="container-fluid bg">
		<div class="card-deck">
			<div class="card" style="width: 18rem;">
				<img src="images/live.jpg" class="card-img-top" alt="...">
				<div class="card-body">
					<p class="card-text">Biggest requirement in this technology world is to provide ball by ball updates of the score.</p>
					<a href="/live-score" class="btn btn-primary">LIVE SCORE</a>
				</div>
			</div>
			<div class="card" style="width: 18rem;">
				<img src="images/sch.jpg" class="card-img-top" alt="...">
				<div class="card-body">
					<p class="card-text">Complete list of all the matches that is coming for your tournament.</p>
					<a href="/schedule" class="btn btn-primary">SCHEDULE</a>
				</div>
			</div>
			<div class="card">
				<img src="images/sb.jpg" class="card-img-top" alt="...">
				<div class="card-body">
					<p class="card-text">Anytime you can see the full score board of Running Match & Completed match of any season.</p>
					<a href="#" class="btn btn-primary">SCORE BOARD</a>
				</div>
			</div>
			<div class="card">
				<img src="images/team.jpg" class="card-img-top" alt="...">
				<div class="card-body">
					<p class="card-text">Complete list of all teams who are participating the tournament also full list of players. You can see Players by Team.</p>
					<a href="#" class="btn btn-primary">TEAM AND PLAYERS</a>
				</div>
			</div>
			<div class="card">
				<img src="images/statistics.jpg" class="card-img-top" alt="...">
				<div class="card-body">
					<p class="card-text">Top 10 performer in each category will be listed well as per international standard. ( e.g best score, best bowling, top wickets e.t.c)</p>
					<a href="#" class="btn btn-primary">STATICS</a>
				</div>
			</div>
			<div class="card">
				<img src="images/old.jpg" class="card-img-top" alt="...">
				<div class="card-body">
					<p class="card-text">To view the scores and details of previous matches</p>
					<a href="#" class="btn btn-primary">OLD MATCHES</a>
				</div>
			</div>
		</div>
		</div>
	</section>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
	
</body>
</html>