var urlBasica = "https://www.gravatar.com/avatar/";
var elementEmail = document.querySelector('p.class-email');
var email = elementEmail.innerHTML;
var urlFinal = urlBasica +  md5(email);

var elementIMG = document.querySelector("img.aw-logged-user__picture");
	elementIMG.setAttribute("src",urlFinal);