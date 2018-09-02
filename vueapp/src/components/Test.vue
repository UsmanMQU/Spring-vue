<template>
<div class ="users">
<h1>AccountApp</h1>


  <br />

<br/><br/>
<span id="span1">ID</span>
<span id="span2">Name</span>
<span id="span3">Email</span>
<br/>
<ul id="list" style="list-style-type:none" >
<li v-for="user in users">
{{user.id}}  <span :class="{contacted: user.contacted}" id="idS">
{{user.name}}</span> <span :class="{contacted: user.contacted}" id="userS"> {{user.email}} <button v-on:click="deleteUser(user)" id="buttonId">x</button>
</span>
<br/><br/>
</li>
</ul>
</div>
</template>

<script>
import axios from 'axios'
export default {
name: 'users',

data() {
return {
  newUser:{},
  users: []
}
},
methods:{
  deleteUser: function(user, id){
    axios.delete('http://localhost:8090/api/v1/accounts/delete/' + user.id)
    .then(function(response){
      console.log(response)
    })
    .catch(error => {
      console.log(error.response)
    })
  },
},

created: function(){
  var self = this;
  axios.get('http://localhost:8090/api/v1/accounts')
  .then(function(response){
    console.log(response)
    self.users = response.data;
  })
},

}
</script>

<style scoped>



#buttonId
{
    color: white;
    background-color: red;
}
#span1
{
  position: absolute;
  left: 50px;
  margin-right: 50px;
  margin-top: 0px;
  font-weight: bold;
  font-family: arial, sans-serif;
}
#span2
{
  position: absolute;
  left: 106px;
  margin-right: 50px;
  margin-top: 0px;
  font-weight: bold;
  font-family: arial, sans-serif;
}
#span3
{
  position: absolute;
  left: 305px;
  margin-right: 50px;
  margin-top: 0px;
  font-weight: bold;
  font-family: arial, sans-serif;
}
#idS
{
  position: absolute;
  left: 100px;
  margin-right: 50px;
  margin-top: 0px;
}
#userS
{
  position: absolute;
  left: 300px;
  padding: 6px 5px;
}
#list
{
  font-weight: bold;
  font-family: arial, sans-serif;
}

</style>
