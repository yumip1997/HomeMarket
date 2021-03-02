<template>
    <sui-grid-row>
        <label class="block text-gray-600 text-sm font-bold mb-2" for="startDate">시작일</label>
        <v-date-picker v-model="startDate">
            <template v-slot="{ inputValue, inputEvents }">
                <input
                    class="bg-white border px-2 py-1 rounded"
                    :value="inputValue"
                    v-on="inputEvents"/>
            </template>
        </v-date-picker>

        <label class="block text-gray-600 text-sm font-bold mb-2" for="endDate">종료일</label>
        <v-date-picker v-model="endtDate">
            <template v-slot="{ inputValue, inputEvents }">
                <input
                    class="bg-white border px-2 py-1 rounded"
                    :value="inputValue"
                    v-on="inputEvents"/>
            </template>
        </v-date-picker>
    </sui-grid-row>
</template>

<script>
    export default {
        name: 'CalendarBar',
        data: function () {
            return {
                startDate: new Date(), 
                endDate: new Date()
            }
        }

    }
</script>

<style></style>