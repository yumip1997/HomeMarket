<template>
  <div>
  <b-carousel
    id="carousel-fade"
    style="text-shadow: 0px 0px 2px #000"
    fade
    indicators
    img-width="1024"
    img-height="480"
  >
    <b-carousel-slide
      img-src="https://cdn.pixabay.com/photo/2014/08/11/21/39/wall-416060_1280.jpg">
    </b-carousel-slide>
    <b-carousel-slide
      caption="가구"
      img-src="https://picsum.photos/1024/480/?image=12"
    ></b-carousel-slide>
    <b-carousel-slide
      caption="주방"
      img-src="https://picsum.photos/1024/480/?image=22"
    ></b-carousel-slide>
  </b-carousel>
</div>
</template>

<script>
export default {
    name : 'default-page'
}
</script>

<style>

</style>