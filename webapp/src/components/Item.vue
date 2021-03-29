<template>
  <div class="bg-white p-8 rounded-lg shadow-lg">
    <div class="mb-8">
      <div class="flex justify-between">
        <div class="text-2xl">{{ item.name }}</div>
        <div>
          <div
            class="uppercase rounded-full py-2 px-4 font-medium bg-red-100 text-red-800"
            v-if="item.reserved"
          >
            Frátekið
          </div>
          <div
            class="uppercase rounded-full py-2 px-4 font-medium bg-green-100 text-green-800"
            v-else
          >
            Laust
          </div>
        </div>
      </div>
      <div class="font-medium text-blue-700">
        <a :href="item.url">Skoða betur</a>
      </div>
    </div>
    <div class="flex items-center" v-if="item.reserved">
      <div class="flex-1 mr-8">
        <span class="font-medium">{{ item.reserver }}</span>
        <span> ætlar að taka þetta á sig!</span>
      </div>
      <button
        @click="emit('remove', item)"
        class="py-2 px-8 bg-blue-500 text-white rounded-lg"
      >
        Afskrá
      </button>
    </div>
    <div v-else class="flex items-center">
      <div class="flex-1 mr-8">
        <input
          type="text"
          placeholder="Settu inn nafn"
          class="py-2 px-8 border rounded-lg w-full"
        />
      </div>
      <button
        @click="emit('add', item)"
        class="py-2 px-8 bg-blue-500 text-white rounded-lg"
      >
        Taka frá
      </button>
    </div>
  </div>
</template>

<script setup>
  const props = defineProps({
    item: Object,
  });
</script>
