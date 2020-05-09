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
        <div v-bind:key="file.id" v-for="file in files" class="rh-upload-card">
          <h4 class="title truncate">{{ file.name }}</h4>
          <p style="margin-bottom:0px;">Type: {{ file.type }}</p>
          <input placeholder="title" type="text" class="rh-input-box" />
          <v-select :items="factions" class="rh-input-box" v-model="file.selectedFactions" hide-details
                    label="Select Factions" style="height:auto;margin-bottom:5px;background:rgba(0,0,0,0.00);"
                    solo dense multiple clearable background-color="rgba(0,0,0,0.05)"/>
      <!-- <multiselect v-model="factionSelector" :options="factions"></multiselect>
           <multiselect v-model="PlayerSelector" :options="players" class="rh-input-box"></multiselect> -->
          <input placeholder="tags?" type="text" class="rh-input-box" />
          <textarea class="rh-input-box" placeholder="description" style="height:100px;resize:none;" />
        </div>
        <v-btn color="light-blue darken-4" dark block><v-icon color="white" style="margin-right: 8px;">mdi-cloud-upload</v-icon>Submit</v-btn>
      </span>
    </div>
  </div>
</template>

<script>
export default {
  data:() => ({
    files: [],
    factions: ["Orks", "Empire", "Dwarves", "Chaos", "Beastmen", "High Elves", "Dark Elves", "Wood Elves"],
    players: [],
    factionSelected: [],
    competitive: true,                                                               
    uploads: [],


  }),
  created() {

  },
  methods:{
    submit: function() {
      //https://developer.mozilla.org/en-US/docs/Web/API/XMLHttpRequestEventTarget/onprogress
      // We need to track the progress of the upload.  (sent / total) * 100 + '%'
      // We will create an upload object and store it in the uploads array. The 'on progress' method will be used to
      // - update each uploads progress individually so that we can display a loading bar.

    }
  },
  watch: {
    files: function() {
      console.log(this.files);
    }

  },
}
</script>

<style>
.rh-upload-card {
  position: relative;
  min-height: 100px;
  width: calc(100%/3.1);
  background:#ffffff;
  box-sizing: border-box;
  padding: 8px 20px;
  border-radius: 8px;
  margin-bottom: 8px;
  margin-right: 8px;
  display: inline-block;
}
</style>