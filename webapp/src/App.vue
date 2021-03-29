<template>
  <div class="flex flex-col items-center justify-center">
    <Header class="mb-8"> Gjafalisti </Header>
    <Item
      class="flex flex-col w-full mb-4"
      v-for="item in items"
      :item="item"
      :key="item.id"
    />
  </div>
</template>

<script setup>
  import { ref, onMounted } from "vue";
  import api from "./api";
  import Header from "./components/Header.vue";
  import Item from "./components/Item.vue";

  const items = ref([]);
  onMounted(async () => {
    items.value = await api.get("/items");
  });
</script>
