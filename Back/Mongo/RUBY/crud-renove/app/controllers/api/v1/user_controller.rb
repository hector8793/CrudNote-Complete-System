class Api::V1::UserController < ApplicationController
    def index
        #render 'new'
        @user = User.all
        render json: @user
    end
    
    def new
        @user = User.new
    end
    
    def create
        @user = User.new(user_params)
        @user.save
    end
    
    def edit
        @user = User.find(params[:id])
    end
    
    def update
        @user = User.find(params[:id])

        if @user.update_attributes(user_params)
           redirect_to root_path, notice: "#{@user.name} #{@user.email} has been updated!" and return
         end

         render 'edit'
    end

    def destroy
        @user = user.find(params[:id])
        @user.destroy

        redirect_to root_path, notice: "#{@user.name} #{@user.email} has been deleted!" and return
    end

    private
    def user_params
        params.require(:user).permit(:name, :email, :pwd)
    end
end
