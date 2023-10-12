const password = document.getElementById('password');
const icon = document.getElementById('icon');

function showHide(){
  if(password.type === 'password'){
    password.setAttribute('type','text');
    icon.classList.add('hide')
  }
  else{
    password.setAttribute('type','password');
    icon.classList.remove('hide')
  }
}

const passwordtwo = document.getElementById('passwordtwo') 
const icontwo = document.getElementById('icontwo');

function showHidetwo(){
  if(passwordtwo.type === 'password'){
    passwordtwo.setAttribute('type','text');
    icontwo.classList.add('hide')
  }
  else{
    passwordtwo.setAttribute('type','password');
    icontwo.classList.remove('hide')
  }
}  