<template>
  <div class="rh-display-container">
    <div class="rh-content-container">
      <h1>Home Placeholder for Replay Hoster Upload Page</h1>
      <v-file-input v-model="files" dense :show-size="1000" counter multiple label="File input"
                    color="light-blue darken-4" prepend-icon="mdi-cloud-upload" outlined >
        <template v-slot:selection="{ index, text }">
          <v-chip
            v-if="index < 2"
            color="light-blue darken-4"
            dark
            label
            small
          >
            {{ text }}
          </v-chip>

          <span
            v-else-if="index === 2"
            class="overline grey--text text--darken-3 mx-2"
          >
            +{{ files.length - 2 }} File(s)
          </span>
        </template>

      </v-file-input>

      <span v-if="files.length > 0">
        <h4>Please fill out a little bit of information about each file!</h4>
        <p style="margin-bottom:0px;">This will assist in search / browse capabilities.</p>
        <UploadCard v-bind:key="file.id" v-for="file in files" :file="file" :factions="factions" />
        <v-btn color="light-blue darken-4" dark block @click="submit()"><v-icon color="white" style="margin-right: 8px;">mdi-cloud-upload</v-icon>Submit</v-btn>
      </span>

      <span v-if="uploads.length > 0">
        <p v-for="upload in uploads">Hello.. {{ upload.curr }} / {{ upload.total }}</p>
      </span>
    </div>
  </div>
</template>

<script>
import UploadCard from '@/components/Cards/UploadCard';
export default {
  data:() => ({
    files: [],
    factions: ["Orks", "Empire", "Dwarves", "Chaos", "Beastmen", "High Elves", "Dark Elves", "Wood Elves"],
    players: [],
    factionSelected: [],
    competitive: true,                                                               
    uploads: [],


  }),
  components: {
    UploadCard,
  },
  created() {

  },
  methods:{
    submit: function() {
      //https://developer.mozilla.org/en-US/docs/Web/API/XMLHttpRequestEventTarget/onprogress
      // We need to track the progress of the upload.  (sent / total) * 100 + '%'
      // We will create an upload object and store it in the uploads array. The 'on progress' method will be used to
      // - update each uploads progress individually so that we can display a loading bar.

      let formDataObj = new FormData();
      formDataObj.append("file",this.files[0]);
      formDataObj.append("name","test");
      formDataObj.append("factions","oop");
      formDataObj.append("players","oh");
      formDataObj.append("competitive",true);
      formDataObj.append("description","quick descrip");

      // Make an HttpRequest.
      let request = new XMLHttpRequest();
      request.open("POST","/api/replay/v1/upload");

      // Declaring here like this lets us access outside data from callback functions.
      let here = this;

      let uploadObject = {};
      uploadObject.total = this.files[0].size;

      this.uploads.push(uploadObject);

      request.onloadstart = function(e) {
        uploadObject.curr = 0;
      }

      // Grab the progress for the upload.
      request.upload.onprogress = function(e) {
        uploadObject.curr = e.total;
      }

      request.send(formDataObj);

    },
    doSubmit: function() {
      fetch("/api/replay/v1/test", {
        method: 'GET'
      });
    },
  },
  watch: {

  },
}
</script>

<style>
</style>