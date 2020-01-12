<template>
  <div class="hello">
    <template v-if="!edit">
      <form @submit.prevent="addUser">
        <input v-model="user.name" type="text" />
        <input v-model="user.email" type="text" />
        <input v-model="user.pwd" type="password" name id />
        <button type="sudmit">Agregar</button>
      </form>
    </template>
    <template v-if="edit">
      <form @submit.prevent="editUser">
        <input v-model="user.name" type="text" />
        <input v-model="user.email" type="text" />
        <input v-model="user.pwd" type="password" name id />
        <button type="sudmit">Guardar</button>
      </form>
    </template>
    <div>
      <table>
        <thead></thead>
        <tbody>
          <tr v-for="user of users" :key="user._id">
            <td>{{user.name}}</td>
            <td>{{user.email}}</td>
            <td>{{user.pwd}}</td>
            <td>
              <button @click="deleteUser(user._id)"></button>
            </td>
            <td>
              <button @click="updateUser(user._id)"></button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
class User {
  constructor(name, email, pwd, id) {
    this.name = name;
    this.email = email;
    this.pwd = pwd;
    this._id = id;
  }
}
export default {
  data() {
    return {
      user: new User(),
      users: [],
      edit: false
    };
  },
  created() {
    this.getUsers();
  },
  methods: {
    addUser() {
      fetch("http://localhost:3000/api/user", {
        method: "POST",
        body: JSON.stringify(this.user),
        headers: {
          Accept: "application/json",
          "Content-type": "application/json"
        }
      })
        .then(res => res.json())
        .then(data => {
          window.console.log(data);
          this.getUsers();
        });
    },
    getUsers() {
      fetch("http://localhost:3000/api/users")
        .then(res => res.json())
        .then(data => {
          this.users = data;
          window.console.log(this.users);
        });
    },
    deleteUser(id) {
      fetch("http://localhost:3000/api/user/" + id, {
        method: "DELETE",
        headers: {
          Accept: "application/json",
          "Content-type": "application/json"
        }
      });
      this.getUsers();
    },
    updateUser(id) {
      fetch("http://localhost:3000/api/user/" + id)
        .then(res => res.json())
        .then(data => {
          this.user = data;
          this.edit = true;
        });
    },
    editUser() {
      fetch("http://localhost:3000/api/user/" + this.user._id, {
        method: "PUT",
        body: JSON.stringify(this.user),
        headers: {
          Accept: "application/json",
          "Content-type": "application/json"
        }
      })
        .then(res => res.json())
        .then(data => {
          window.console.log(data);
          this.getUsers();
          this.user = new User();
        });
    }
  },
  name: "crud",
  props: {
    msg: String
  }
};
</script>