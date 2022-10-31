package com.javeriana.web.four.covet19.Usuarios.Mascota.Infrastructure.DomainEventSubscribers;

//@DomainEventSubscriber({ProductColorUpdatedDomainEvent.class})
public class UpdateMascota {
    /**
        private ProductUpdateProductColor productUpdateProductColor;

        public UpdateProductColorOnProductColorUpdated(ProductUpdateProductColor productUpdateProductColor) {
            this.productUpdateProductColor = productUpdateProductColor;
        }

        @EventListener
        public void on(ProductColorUpdatedDomainEvent event) {
            this.productUpdateProductColor.execute(event.aggregateId(), event.getProductColorId(),
                    event.getName(), event.getQuantity(), event.isHasStock(), event.getRgb());
        }

    }
     */
}
