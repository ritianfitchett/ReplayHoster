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
        <div v-for="file in files" class="rh-upload-card">
          <h4 class="title">{{ file.name }}</h4>
          <p style="margin-bottom:0px;">Type: {{ file.type }}</p>
          <input placeholder="title" type="text" class="rh-input-box" />
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

  }),
  created() {

  },
  methods:{

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