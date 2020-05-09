<template>
  <div class="rh-upload-card">
    <h4 class="title truncate">{{ file.name }}</h4>
    <p style="margin-bottom:0px;">Type: {{ file.type }}</p>
    <input placeholder="title" v-model="file.title" type="text" class="rh-input-box" />
    <v-select :items="factions" class="rh-input-box" v-model="file.selectedFactions" hide-details
              label="Select Factions" style="height:auto;margin-bottom:5px;background:rgba(0,0,0,0.00);"
              solo dense multiple clearable background-color="rgba(0,0,0,0.05)"/>
    <textarea class="rh-input-box" placeholder="description" v-model="file.description" style="height:100px;resize:none;" />
    <span v-if="file.currUpload">
      <p>Weeee uploading</p>
    </span>
    <br />
    <br />
    <pre>
      {{ file.currUpload }}
      {{ file.total }}
    </pre>
  </div>
</template>

<script>
export default {
  props: {
    file: File,
    factions: Array,
  },
  data:() => ({

  }),
  created() {
    this.file.currUpload=0;
  },
  methods:{

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