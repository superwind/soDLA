package nvdla
import chisel3._
import chisel3.experimental._
import chisel3.util._

class NV_NVDLA_MCIF_READ_IG_cvt(implicit conf: nocifConfiguration) extends Module {
    val io = IO(new Bundle{
        //general clock
        val nvdla_core_clk = Input(Clock())
        val nvdla_core_rstn = Input(Bool())
        val reg2dp_rd_os_cnt = Input(UInt(8.W))

        //eg2ig
        val eg2ig_axi_vld = Input(Bool())

        //spt2cvt
        val spt2cvt_req_valid = Input(Bool())
        val spt2cvt_req_ready = Output(Bool())
        val spt2cvt_req_pd = Input(UInt((conf.NVDLA_MEM_ADDRESS_WIDTH+11).W))

        //mcif2noc
        val mcif2noc_axi_ar_arvalid = Output(Bool())
        val mcif2noc_axi_ar_arready = Input(Bool())
        val mcif2noc_axi_ar_arid = Output(UInt(8.W))
        val mcif2noc_axi_ar_arlen = Output(UInt(4.W))
        val mcif2noc_axi_ar_araddr = Output(UInt(conf.NVDLA_MEM_ADDRESS_WIDTH.W))
    })

    withClock(io.nvdla_core_clk){
    }
}

