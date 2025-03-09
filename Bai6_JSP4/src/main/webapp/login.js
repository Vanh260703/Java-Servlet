/**
 * 
 */
function registerCheck(){
	let isValid = true;
	let mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/; //check email
	let numberRegex = /^\d+$/; // chỉ chứa số
	let specalCharacterRegex = /[^a-zA-Z\s]/; //  // special character
	let newUser = document.getElementById("newUser");
	let fullName = document.getElementById("fullName");
	let password = document.getElementById("password");
	let userName = document.getElementById("userName");
	if( newUser.value.trim() === ""){
		alert("Không được để trống tên đăng nhập!");
		isValid = false;
	}else{
		if(!newUser.value.match(mailformat) && !newUser.value.match(numberRegex) ){
				isValid = false;
				alert("Không đúng định dạng số điện thoại hoặc email")
			}
	}
	
	if(password.value.trim() === ""){
		alert("Không được để trống mật khẩu");
		isValid = false;
	}else{
		if(password.value.length > 20 || password.value.length < 6){
			alert("Mật khẩu không được vượt quá 20 kí tự!")
			isValid = false;
		}
	}
	
	if(fullName.value.trim() === ""){
		alert("Không được để trống họ và tên")
		isValid = false;
	}else{
		if(fullName.value.match(numberRegex) || fullName.value.match(specalCharacterRegex)){
				alert("Họ và tên không được chứa số hoặc ký tự đặc biệt");
				isValid = false;	
			}
	}
	
	if(userName.value.trim() === ""){
		alert("Không được để trống tên đăng nhập");
		isValid = false;
	}else{
		if(userName.value.length < 5){
			alert("Tên đăng nhập không được dưới 5 kí tự!")
			isValid = false;
		}
	}
	
	

	if(!isValid){
		event.preventDefault();
		return false;
	}
	
	if(isValid){
		
		alert("Đăng ký thành công!")
	}
	
	
	
}