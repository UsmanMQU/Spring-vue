<template>
<div class ="users">
<h1>AccountApp</h1>


  <br />
<input type="text" v-model="newUser.name" placeholder=" Enter name" id="nameId">
<br />
<br />
<input type="text" v-model="newUser.email" placeholder=" Enter email" id="emailId">
<br /><br />
</form>
<button id="addButton" v-on:click="post">Add account</button>
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

  post: function(){
  axios.post('http://localhost:8090/api/v1/accounts',{
      name:this.newUser.name,
      email:this.newUser.email,
    }).then(function(data)
  {
    console.log(data);
    this.users = response.data;
  })
  .catch(error => {
    console.log(error.response)
  });
}
},
}
</script>

<style scoped>
h1
{
  font-size: 1.5em;
  margin-top: 0em;
  color: grey
}
h2
{
  font-size: 1.0em;
  margin-top: 0em;
  color: grey
}
#nameId
{
  border: 1px solid #555;
  border-color: grey;
  padding: 6px 1px;
  width: 65%
}
#emailId{
  border: 1px solid #555;
  border-color: grey;
  padding: 6px 1px;
  width: 65%
}

#addButton
{
  background-color: white; /* Green */
  border: 2px solid grey;
  color: grey;
  padding: 6px 12px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
}
#addButton:hover
{
  background-color: grey;
  color: white;
}
</style>
