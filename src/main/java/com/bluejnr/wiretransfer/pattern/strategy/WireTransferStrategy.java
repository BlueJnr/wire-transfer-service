package com.bluejnr.wiretransfer.pattern.strategy;

import com.bluejnr.wiretransfer.model.domain.WireTransferVO;
import com.bluejnr.wiretransfer.pattern.state.WireTransferState;
import com.bluejnr.wiretransfer.pattern.state.impl.CanceledWireTransfer;
import com.bluejnr.wiretransfer.pattern.state.impl.ConfirmedPaymentWireTransfer;
import com.bluejnr.wiretransfer.pattern.state.impl.CreatedWireTranfer;
import com.bluejnr.wiretransfer.pattern.state.impl.ExpiredWireTransfer;
import com.bluejnr.wiretransfer.pattern.state.impl.RejectedWireTransfer;
import com.bluejnr.wiretransfer.pattern.state.impl.ReviewComplianceWireTransfer;
import com.bluejnr.wiretransfer.pattern.state.impl.ReviewDataWrongWireTransfer;
import com.bluejnr.wiretransfer.pattern.state.impl.SentWireTransfer;
import com.bluejnr.wiretransfer.pattern.state.impl.StartedWireTranfer;
import com.bluejnr.wiretransfer.pattern.state.impl.SuccessfulWireTransfer;
import com.bluejnr.wiretransfer.pattern.state.impl.WaitingPaymentWireTransfer;

public enum WireTransferStrategy {
	CANCELED {
		@Override
		public WireTransferState get(WireTransferVO wireTransferVO) {
			return new CanceledWireTransfer(wireTransferVO);
		}
	},
	CONFIRMED_PAYMENT {
		@Override
		public WireTransferState get(WireTransferVO wireTransferVO) {
			return new ConfirmedPaymentWireTransfer(wireTransferVO);
		}
	},
	CREATED {
		@Override
		public WireTransferState get(WireTransferVO wireTransferVO) {
			return new CreatedWireTranfer(wireTransferVO);
		}
	},
	EXPIRED {
		@Override
		public WireTransferState get(WireTransferVO wireTransferVO) {
			return new ExpiredWireTransfer(wireTransferVO);
		}
	},
	REJECTED {
		@Override
		public WireTransferState get(WireTransferVO wireTransferVO) {
			return new RejectedWireTransfer(wireTransferVO);
		}
	},
	REVIEW_COMPLIANCE {
		@Override
		public WireTransferState get(WireTransferVO wireTransferVO) {
			return new ReviewComplianceWireTransfer(wireTransferVO);
		}
	},
	REVIEW_DATA_WRONG {
		@Override
		public WireTransferState get(WireTransferVO wireTransferVO) {
			return new ReviewDataWrongWireTransfer(wireTransferVO);
		}
	},
	SENT {
		@Override
		public WireTransferState get(WireTransferVO wireTransferVO) {
			return new SentWireTransfer(wireTransferVO);
		}
	},
	STARTED {
		@Override
		public WireTransferState get(WireTransferVO wireTransferVO) {
			return new StartedWireTranfer(wireTransferVO);
		}
	},
	SUCCESSFUL {
		@Override
		public WireTransferState get(WireTransferVO wireTransferVO) {
			return new SuccessfulWireTransfer(wireTransferVO);
		}
	},
	WAITING_PAYMENT {
		@Override
		public WireTransferState get(WireTransferVO wireTransferVO) {
			return new WaitingPaymentWireTransfer(wireTransferVO);
		}
	};

	public abstract WireTransferState get(WireTransferVO wireTransferVO);
}
