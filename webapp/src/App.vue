<template>
  <v-app>
    <div class="background" />
    <v-content>
      <NavBar />
      <router-view/>
    </v-content>
  </v-app>
</template>

<script>
import NavBar from '@/components/NavBar/NavBar'
export default {
  name: 'App',
  components: {
    NavBar,
  },
  data: () => ({
  }),
};
</script>

<style>
.rh-application-layout {
  height: 100%;
  width: 100%;
  display: grid;
  grid-template-columns: auto;
  grid-template-rows: 35px auto;
}
</style>