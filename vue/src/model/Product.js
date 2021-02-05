class Product{
    constructor(productId, productName, productDetail, categroies, quantity, price, memberId, uploadDate){
        this.productId = productId;
        this.productName = productName;
        this.productDetail = productDetail;
        this.categroies = categroies;
        this.quantity = quantity;
        this.price = price;
        this.memberId = memberId;
        this.uploadDate = uploadDate;
    }
}

export default Product;