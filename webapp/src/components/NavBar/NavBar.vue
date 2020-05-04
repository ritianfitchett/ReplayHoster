<template>
  <div class="rh-nav-container">
    <!-- Left Side -->
    <span>
      <div class="rh-icon-or-name-container">
        <h3 class="noselect">Replay Hoster</h3>
      </div>
      <router-link v-for="button in buttonsLeft" tag="button" :to="button.to" class="rh-nav-button noselect">
        {{ button.name }}
      </router-link>
    </span>
    <!-- Right Side -->
    <span>
      <router-link v-for="button in buttonsRight" tag="button" :to="button.to" class="rh-nav-button noselect">
        {{ button.name }}
      </router-link>
      <!-- placeholder until we determine login requirement / whatever -->
      <button class="rh-nav-button noselect">
        Log In
      </button>
    </span>
  </div>
</template>

<script>
export default {
  data:() => ({
    buttonsLeft: [
      {
        to: "/",
        name: "Home",
      },
      {
        to: "/browse",
        name: "Browse",
      },
      {
        to: "/upload",
        name: "Upload",
      },
    ],
    buttonsRight: [
      {
        to: "/info",
        name: "Getting Started",
      },
    ],

  }),
  created() {

  },
  methods:{

  },
}
</script>

<style>
.rh-nav-container {
  position: fixed;
  top: 0px;
  left: 0px;
  height: 47px;
  width: 100%;
  display: grid;
  grid-template-columns: auto 400px;
  grid-template-rows: auto;
  grid-gap: 8px;
  box-sizing: border-box;
  padding-left: 40px;
  padding-top: 5px;
  background:linear-gradient(90deg,#ffffff,#f5f5f5,#f0f0f0);
  border-bottom: 2px solid rgba(80,80,80,0.6);
  z-index: 9999;
}
.rh-icon-or-name-container {
  display: inline-block;
  margin-right: 20px;
  width: 200px;
}
.rh-nav-button {
  display: inline-block;
  margin-right: 8px;
  background: rgba(255,255,255,0.0);
  border: 2px solid rgba(120,120,120,0.0);
  min-width: 45px;
  border-radius: 5px;
  color: rgba(120,120,120);
  outline: none;
  box-sizing: border-box;
  padding: 4px 15px;
  font-weight: bold;
  transition: 0.6s;
}
.rh-nav-button:hover {
  cursor: pointer;
  border: 2px solid rgba(120,120,120,0.8);
  background: rgba(255,255,255,0.1);
}
.rh-nav-button:active {
  transform: scale(0.94);
}
</style>